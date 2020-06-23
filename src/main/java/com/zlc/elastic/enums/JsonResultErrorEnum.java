package com.zlc.elastic.enums;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/5 16:30
 * @Version 1.0
 */
public enum JsonResultErrorEnum implements BaseErrorInterface {
    T00001("T00001","服务出错"),
    T99999("T99999","listener不能为空"),
    ;

    private String code;
    private String message;

    JsonResultErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
