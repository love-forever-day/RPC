package com.rpc.provider;


import com.rpc.common.service.UserService;
import com.rpc.factory.service.VertsHttpService;
import com.rpc.factory.service.HttpService;
import com.rpc.factory.registry.LocalRegistry;
/**
 * @ClassName %{NAME}
 * @Description TODO
 * @synposis TODO
 */
public class provider {
    public static void main(String[] args) {
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);
        HttpService httpServer=new VertsHttpService();
        httpServer.doStart(8080);
    }
}
