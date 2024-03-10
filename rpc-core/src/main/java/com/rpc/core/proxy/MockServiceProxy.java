package com.rpc.core.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName mock动态代理类
 * @Description TODO
 * @synposis TODO
 */
@Slf4j
public class MockServiceProxy implements InvocationHandler {
    /**
     * @descrieptiaion 调用代理
     * @param
     * @return
     * @author weidingqian
     * @date 2024/3/10 20:10
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Class<?> returnType = method.getReturnType();
        log.info("mock invoke{}",method.getName());
        return getDefaultObejct(returnType);
    }

    private Object getDefaultObejct(Class<?> type) {
        //判断是否是基础类型
        if(type.isPrimitive()){
         if(type == boolean.class)
             return false;
         else if(type==short.class)
             return (short)0;
         else if(type == int.class){
             return 0;
         }
      }
        return null;
    }

}
