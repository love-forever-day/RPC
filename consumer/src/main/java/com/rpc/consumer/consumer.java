package com.rpc.consumer;

import com.rpc.common.model.User;
import com.rpc.common.service.UserService;
import com.rpc.consumer.proxy.ServiceProxyFactory;


/**
 * @ClassName %{NAME}
 * @Description TODO
 * @synposis TODO
 */
public class consumer {


    public static void main(String[] args) {
//        UserService service=new UserServiceProxy();
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
    }
}
