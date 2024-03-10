package com.rpc.core;

import com.rpc.core.config.RpcConfig;

import com.rpc.core.constant.RpcConstan;
import com.rpc.core.utils.ConfigUtil;
import com.sun.org.apache.xml.internal.security.Init;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Rpc启动类
 * @Description TODO
 * @synposis TODO
 */
@Slf4j
public class RpcApplication {
    private  static volatile RpcConfig rpcConfig;
    /**
     * @descrieptiaion 初始化
     * @param newRpcConfig
     * @return void
     * @author weidingqian
     * @date 2024/3/10 1:12
     */

    public static void init(RpcConfig newRpcConfig){
        rpcConfig=newRpcConfig;
        log.info(rpcConfig.toString());
    }
    public static void init(){
        RpcConfig newRpcConfig;
        try{
            newRpcConfig= ConfigUtil.loadConfig(RpcConfig.class,
                    RpcConstan.DEFAULT_CONFIG_PREFIX);
        }catch (Exception e){
            newRpcConfig=new RpcConfig();
        }
        init(newRpcConfig);
    }
    public static RpcConfig getRpcConfig(){
        if(rpcConfig == null){
            synchronized (RpcApplication.class){
                if(rpcConfig==null){
                    init();
                }
            }
        }
        return rpcConfig;
    }
}
