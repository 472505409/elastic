package com.zlc.elastic.service;

import com.zlc.elastic.listener.ESAsyncListener;
import org.elasticsearch.action.index.IndexResponse;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/4 20:37
 * @Version 1.0
 */
public interface IElasticSearchService {

    /**
     * 同步的索引方法
     * @param t
     * @param index
     * @param id
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> IndexResponse putIndex(T t, String index, String id) throws IOException;

    /**
     * 异步的索引方法
     * @param t 需要索引的对象
     * @param index
     * @param id
     * @param listenerResponse
     * @param <T>
     * @throws IOException
     */
    <T> void putIndexAsync(T t, String index, String id, ESAsyncListener listenerResponse);

    /**
     * 通过GetRequest搜索
     * @param response 返回的泛型对象
     * @param index
     * @param id
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T get(T response, String index, String id) throws IOException;
}
