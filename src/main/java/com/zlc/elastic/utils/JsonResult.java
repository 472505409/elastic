package com.zlc.elastic.utils;

import com.alibaba.fastjson.JSON;
import com.zlc.elastic.enums.BaseErrorInterface;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * <p>
 * 包装接口返回
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/5 16:18
 * @Version 1.0
 */
public class JsonResult<T> implements Serializable {
    private final static String SUCCESS_CODE = "0";
    private final static String SUCCESS_MESSAGE = "success";
    private final static String ERROR_CODE = "1";
    private final static String ERROR_MESSAGE = "error";

    private String code;
    private String message;
    private T response;

    private JsonResult() {
    }

    private JsonResult(String code, String message, T response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    public static <T> JsonResult<T> success(){
        return new JsonResult<>(SUCCESS_CODE, SUCCESS_MESSAGE, null);
    }

    public static <T> JsonResult<T> success(T response){
        return new JsonResult<>(SUCCESS_CODE, SUCCESS_MESSAGE, response);
    }

    public static <T> JsonResult<T> error(){
        return new JsonResult<>(ERROR_CODE,ERROR_MESSAGE,null);
    }

    public static <T> JsonResult<T> error(String code,String message){
        return new JsonResult<>(code,message,null);
    }

    public static <T> JsonResult<T> error(BaseErrorInterface exception){
        return new JsonResult<>(exception.getCode(),exception.getMessage(),null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    @Override
    public String toString() {
        String json = JSON.toJSONString(this);
        if (StringUtils.isEmpty(json)) {
            json = "{\"code\":\"serialize.error\",\"message\":\"serialize.error\",\"response\":\"\"}";
        }

        return json;
    }
}
