package com.zlc.elastic.enums;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/5 16:32
 * @Version 1.0
 */
public interface BaseErrorInterface {
    /**
     * 错误code
     * @return code
     */
    String getCode();

    /**
     * 错误message
     * @return message
     */
    String getMessage();
}
