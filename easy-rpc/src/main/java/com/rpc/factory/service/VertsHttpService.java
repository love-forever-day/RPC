package com.rpc.factory.service;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

/**
 * @ClassName %{NAME}
 * @Description TODO
 * @synposis TODO
 */
public class VertsHttpService implements  HttpService{

    @Override
    public void doStart(int port) {
        Vertx vertx = Vertx.vertx();
        io.vertx.core.http.HttpServer server = vertx.createHttpServer();
        server.requestHandler(new HttpServerHandler());
//        server.requestHandler(request -> {
//            System.out.println("Receive request:"+request.method()+""+request.uri());
//           request.response()
//                   .putHeader("content-type","text/plain")
//                   .end("Hello from Vert.x Http server");
//        });

        server.listen(port,result->{
            if(result.succeeded()){
                System.out.println("服务已经开始监听，端口："+port);
            }else {
                System.out.println("服务监听失败");
            }
        });
    }
}
