package com.cloud.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 前端返回结果类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    //防止data为null设置两个参数的构造函数
    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
