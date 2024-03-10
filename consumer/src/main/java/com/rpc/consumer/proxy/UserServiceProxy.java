package com.rpc.consumer.proxy;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.rpc.common.model.User;
import com.rpc.common.service.UserService;
import com.rpc.core.model.RpcRequest;
import com.rpc.core.model.RpcResponse;
import com.rpc.core.serializer.JdkSerializer;
import com.rpc.core.serializer.Serializer;

import java.io.IOException;

/**
 * @ClassName %{NAME}
 * @Description TODO
 * @synposis TODO
 */
public class UserServiceProxy implements UserService {

    @Override
    public User getUser(User user) {
        //指定序列化器
        Serializer serializer = new JdkSerializer();
        //发请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serverName(UserService.class.getName())
                .methodName("getUser")
                .paramterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;

        try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080").body(bodyBytes).execute()){
            result = httpResponse.bodyBytes();
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
