package com.zlc.elastic.resp;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/8 13:53
 * @Version 1.0
 */
@Data
public class EmployeeRespVo implements Serializable {
    private String id;
    private String content;
}
