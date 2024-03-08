package com.rpc.factory.service;

import com.rpc.factory.model.RpcRequest;
import com.rpc.factory.model.RpcResponse;
import com.rpc.factory.registry.LocalRegistry;
import com.rpc.factory.serializer.JdkSerializer;
import com.rpc.factory.serializer.Serializer;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

import javax.xml.transform.Result;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * @ClassName 请求处理器
 * @Description TODO
 * @synposis TODO
 */
public class HttpServerHandler implements Handler<HttpServerRequest> {


    @Override
    public void handle(HttpServerRequest request) {
        final Serializer serializer=new JdkSerializer();
        System.out.println("Receiver Method:"+request.method());
        request.bodyHandler(body->{
            byte[] bytes=body.getBytes();
            RpcRequest rpcRequest=null;
            System.out.println(Arrays.toString(bytes));
            try {
                rpcRequest=serializer.deserialize(bytes,RpcRequest.class);

            }catch (Exception e){
                e.printStackTrace();
            }
            RpcResponse rpcResponse=new RpcResponse();
            if(rpcResponse==null){
                rpcResponse.setMessage("rpcResonse is null");
                doResponse(request,rpcResponse,serializer);
                return;
            }
            try{
                Class<?> implClass = LocalRegistry.getRegister(rpcRequest.getServerName());
                Method method=implClass.getMethod(rpcRequest.getMethodName(),rpcRequest.getParamterTypes());
                Object result=method.invoke(implClass.newInstance(),rpcRequest.getArgs());
                //封装
                rpcResponse.setData(result);
                rpcResponse.setDataType(method.getReturnType());
                rpcResponse.setMessage("成功");
            } catch (Exception e) {
                e.printStackTrace();
                rpcResponse.setMessage("发送失败");
                rpcResponse.setException(e);
            }
            doResponse(request,rpcResponse,serializer);
        });

    }
    /***
     * @descrieptiaion 响应
     * @param request
     * @param rpcResponse
     * @param serializer
     * @return void
     * @author weidingqian
     * @date 2024/3/7 20:00
     */

    private void doResponse(HttpServerRequest request, RpcResponse rpcResponse, Serializer serializer) {
        HttpServerResponse httpServerResponse = request.response().putHeader("content-type", "application/json");
        try{
            byte[] serialized=serializer.serialize(rpcResponse);
            httpServerResponse.end(Buffer.buffer(serialized));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
