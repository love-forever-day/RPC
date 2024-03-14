package com.rpc.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName %{NAME}
 * @Description TODO
 * @synposis TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    String name;
}
