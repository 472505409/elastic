package com.zlc.elastic.listener;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/8 19:15
 * @Version 1.0
 */
@Service
@Slf4j
public class EmployeeAsyncListener implements ESAsyncListener{
    @Override
    public void indexAsyncSuccess(IndexResponse indexResponse) {
        log.info("employee异步索引成功返回:{}",indexResponse);
    }

    @Override
    public void indexAsyncFailure(Exception e) {
        log.info("employee异步索引失败",e);
    }
}
