package com.rpc.provider;


import com.rpc.common.service.UserService;
import com.rpc.core.service.VertsHttpService;
import com.rpc.core.service.HttpService;
import com.rpc.core.registry.LocalRegistry;
/**
 * @ClassName %{NAME}
 * @Description TODO
 * @synposis TODO
 */
public class provider {
    final static int Port=8080;
    public static void main(String[] args) {
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);
        HttpService httpServer=new VertsHttpService();
        httpServer.doStart(Port);
    }
}
