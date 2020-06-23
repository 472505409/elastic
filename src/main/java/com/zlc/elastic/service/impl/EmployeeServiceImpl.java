package com.zlc.elastic.service.impl;

import com.zlc.elastic.constant.ESConstant;
import com.zlc.elastic.listener.EmployeeAsyncListener;
import com.zlc.elastic.req.EmployeeReqVo;
import com.zlc.elastic.resp.EmployeeRespVo;
import com.zlc.elastic.service.IElasticSearchService;
import com.zlc.elastic.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/5 17:07
 * @Version 1.0
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IElasticSearchService iElasticSearchService;

    @Autowired
    private EmployeeAsyncListener employeeAsyncListener;

    @Override
    public IndexResponse putEmployee(EmployeeReqVo reqVo) {
        IndexResponse response = null;
        try {
            response = iElasticSearchService.putIndex(reqVo, ESConstant.EMPLOYEE,reqVo.getId());
        } catch (Exception e) {
            log.info("保存出错",e);
        }
        return response;
    }

    @Override
    public EmployeeRespVo getEmployee(String id) {
        EmployeeRespVo respVo = null;
        try {
            respVo = iElasticSearchService.get(new EmployeeRespVo(),ESConstant.EMPLOYEE,id);
        } catch (IOException e) {
            log.info("查询出错",e);
        }
        return respVo;
    }

    @Override
    public void putEmployeeAsync(EmployeeReqVo reqVo) {
        iElasticSearchService.putIndexAsync(reqVo, ESConstant.EMPLOYEE,reqVo.getId(),employeeAsyncListener);
    }
}
