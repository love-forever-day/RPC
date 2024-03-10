package com.rpc.core.service;

/**
 * @ClassName 服务器
 * @Description 服务提供者对外端口
 * @synposis
 */
public interface HttpService {
    /***
     * @descrieptiaion 启动服务器
     * @param port 端口
     * @author weidingqian
     * @date 2024/3/6 19:21
     */
    void doStart(int port);
}
