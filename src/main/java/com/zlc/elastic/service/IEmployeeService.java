package com.zlc.elastic.service;

import com.zlc.elastic.req.EmployeeReqVo;
import com.zlc.elastic.resp.EmployeeRespVo;
import org.elasticsearch.action.index.IndexResponse;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/5 17:06
 * @Version 1.0
 */
public interface IEmployeeService {
    IndexResponse putEmployee(EmployeeReqVo reqVo);

    EmployeeRespVo getEmployee(String id);

    void putEmployeeAsync(EmployeeReqVo reqVo);
}
