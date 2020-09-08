package com.cloud.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.cloudapicommons.entities.CommonResult;

/**
 * @Description: 自定义blockHandler
 */
public class CustomBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"按客户自定义方法实现fallback！！！ ");
    }
}
