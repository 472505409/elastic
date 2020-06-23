package com.zlc.elastic.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/5 10:21
 * @Version 1.0
 */
@Data
public class EmployeeReqVo {
    @NotBlank(message = "id不能为空")
    private String id;
    @NotBlank(message = "content不能为空")
    private String content;
}
