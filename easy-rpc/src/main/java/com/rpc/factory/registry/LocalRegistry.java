package com.rpc.factory.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @ClassName 本地服务注册器
 * @Description TODO
 * @synposis TODO
 */
public class LocalRegistry {
    //服务存储 名称，实现类
    private static final Map<String,Class<?>> map=new ConcurrentHashMap<>();
    /***
     * @descrieptiaion 服务注册
     * @param serverName 服务名
     * @param impleClass  实现类
     * @return void
     * @author weidingqian
     * @date 2024/3/6 23:04
     */

    public static void register(String serverName,Class<?> impleClass){
        map.put(serverName,impleClass);
        System.out.println(serverName);
    }
    public static Class<?> getRegister(String serverName){
        return  map.get(serverName);
    }
    public static boolean removeRegister(String serverName){
        return  map.remove(serverName)!=null;
    }
}
