package com.rpc.provider;

import com.rpc.common.model.User;
import com.rpc.common.service.UserService;

/**
 * @ClassName %{NAME}
 * @Description TODO
 * @synposis TODO
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名"+user.getName());
        return user;
    }
    public short getNumber(){
        return (short) 521;
    }
}
