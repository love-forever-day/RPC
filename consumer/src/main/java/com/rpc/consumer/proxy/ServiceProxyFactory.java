package com.rpc.consumer.proxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName %{NAME}
 * @Description TODO
 * @synposis TODO
 */
public class ServiceProxyFactory {
    /**
     * @descrieptiaion 根据服务类获取代理对象
     * @param serverClass
     * @return T
     * @author weidingqian
     * @date 2024/3/8 11:24
     */

    public static <T> T getProxy(Class<T> serverClass){
        return (T) Proxy.newProxyInstance(
               serverClass.getClassLoader(),
                new Class[]{serverClass},
                new ServiceProxy());
    }
}
