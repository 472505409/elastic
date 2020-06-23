package com.zlc.elastic.controller;

import com.zlc.elastic.path.EmployeePath;
import com.zlc.elastic.req.EmployeeReqVo;
import com.zlc.elastic.resp.EmployeeRespVo;
import com.zlc.elastic.service.IEmployeeService;
import com.zlc.elastic.utils.JsonResult;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/5 10:24
 * @Version 1.0
 */
@RestController
@RequestMapping(EmployeePath.EMPLOYEE_VERSION)
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @RequestMapping(value = EmployeePath.PUT_EMPLOYEE,method = RequestMethod.POST)
    public JsonResult<IndexResponse> putEmployee(@RequestBody @Valid EmployeeReqVo reqVo){
        return JsonResult.success(iEmployeeService.putEmployee(reqVo));
    }

    @RequestMapping(value = EmployeePath.PUT_EMPLOYEE_ASYNC,method = RequestMethod.POST)
    public JsonResult<IndexResponse> putEmployeeAsync(@RequestBody @Valid EmployeeReqVo reqVo){
        iEmployeeService.putEmployeeAsync(reqVo);
        return JsonResult.success();
    }

    @RequestMapping(value = EmployeePath.GET_EMPLOYEE,method = RequestMethod.GET)
    public JsonResult<EmployeeRespVo> getEmployee(@RequestParam("id") String id){
        return JsonResult.success(iEmployeeService.getEmployee(id));
    }
}
