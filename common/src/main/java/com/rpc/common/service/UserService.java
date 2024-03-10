package com.rpc.common.service;

import com.rpc.common.model.User;

/**
 * @ClassName %{NAME}
 * @Description TODO
 * @synposis TODO
 */
public interface UserService {
    User getUser(User user);

    default short getNumber(){
        return  1;
    }
}
