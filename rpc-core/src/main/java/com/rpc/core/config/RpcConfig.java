package com.rpc.core.config;

import lombok.Data;

/**
 * @ClassName rpc配置类
 * @Description 为项目的属性提供了一些默认值
 * @synposis TODO
 */
@Data
public class RpcConfig {

    /*
     **  名称
     */
    private String name="wdq";
     /*
      ** 版本号
      */
    private String version="1.0";
     /*
      ** 服务器主机名
      */
    private String serverName="localhost:";
     /*
      ** 服务器端口号
      */
    private Integer serverPort=8080;

    /*
    **是否开启mock进行模拟调用
    */
    private boolean mock=false;

}
