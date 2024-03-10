package com.rpc.core.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName 请求返回结果
 * @Description TODO
 * @synposis TODO
 */
@Data
public class RpcResponse implements Serializable {
  //响应数据
  private  Object data;
  //响应数据类型
  private Class<?> dataType;
  //响应信息
  private String Message;
  //异常信息
  private Exception exception;
}
