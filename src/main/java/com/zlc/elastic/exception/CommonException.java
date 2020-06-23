package com.zlc.elastic.exception;

import com.zlc.elastic.enums.BaseErrorInterface;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/5 16:43
 * @Version 1.0
 */
public class CommonException extends RuntimeException implements Serializable {
    private BaseErrorInterface baseErrorInterface;

    private CommonException(){
    }

    public CommonException(BaseErrorInterface error){
        super(error.getMessage());
        this.baseErrorInterface = error;
    }

    public BaseErrorInterface getBaseErrorInterface() {
        return baseErrorInterface;
    }
}
