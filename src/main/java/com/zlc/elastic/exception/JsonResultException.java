package com.zlc.elastic.exception;

import com.zlc.elastic.enums.BaseErrorInterface;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/5 17:20
 * @Version 1.0
 */
public class JsonResultException extends CommonException {
    public JsonResultException(BaseErrorInterface error) {
        super(error);
    }
}
