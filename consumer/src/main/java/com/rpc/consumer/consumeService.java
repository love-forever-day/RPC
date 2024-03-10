package com.rpc.consumer;

import com.rpc.core.registry.LocalRegistry;

/**
 * @ClassName %{NAME}
 * @Description TODO
 * @synposis TODO
 */
public class consumeService {
    public void send(String name){
        Class<?> order = LocalRegistry.getRegister("order");
        System.out.println("发送订单");
    }
}
