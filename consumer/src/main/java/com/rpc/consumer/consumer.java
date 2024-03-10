package com.rpc.consumer;

import com.rpc.common.model.User;
import com.rpc.common.service.UserService;
import com.rpc.core.proxy.ServiceProxyFactory;
import com.rpc.core.config.RpcConfig;
import com.rpc.core.proxy.UserServiceProxy;
import com.rpc.core.utils.ConfigUtil;


/**
 * @ClassName %{NAME}
 * @Description TODO
 * @synposis TODO
 */
public class consumer {


    public static void main(String[] args) {
//        RpcConfig rpcConfig= ConfigUtil.loadConfig(RpcConfig.class,"rpc");
//        System.out.println(rpcConfig);

        UserService userService= ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("wdq");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        long number=userService.getNumber();
        System.out.println(number);
    }
}
