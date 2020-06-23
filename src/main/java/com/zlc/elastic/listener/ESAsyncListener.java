package com.zlc.elastic.listener;

import org.elasticsearch.action.index.IndexResponse;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/8 19:04
 * @Version 1.0
 */
public interface ESAsyncListener {
    void indexAsyncSuccess(IndexResponse indexResponse);

    void indexAsyncFailure(Exception e);
}
