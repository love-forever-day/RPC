package com.rpc.factory.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName 请求参数
 * @Description TODO
 * @synposis TODO
 */
@Data
@Builder
public class RpcRequest implements Serializable {
    /**
     * @descrieptiaion 服务名称
     * @date 2024/3/7 16:53
     */
    private String serverName;
    /**
     * @descrieptiaion 方法名称
     * @date 2024/3/7 16:53
     */
    private String methodName;
    /**
     * @descrieptiaion 参数类型列表
     * @date 2024/3/7 16:53
     */
    private Class<?>[] paramterTypes;
    /**
     * @descrieptiaion 参数列表
     * @date 2024/3/7 16:53
     */
    private Object[] args;
}
