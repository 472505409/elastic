package com.zlc.elastic.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zlc.elastic.enums.JsonResultErrorEnum;
import com.zlc.elastic.exception.JsonResultException;
import com.zlc.elastic.listener.ESAsyncListener;
import com.zlc.elastic.service.IElasticSearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/4 20:37
 * @Version 1.0
 */
@Slf4j
@Service
public class ElasticSearchServiceImpl implements IElasticSearchService {
    @Autowired
    @Qualifier("highLevelClient")
    private RestHighLevelClient restHighLevelClient;

    @Override
    public <T> IndexResponse putIndex(T t, String index, String id) throws IOException {
        IndexRequest request = new IndexRequest(index);
        request.id(id);
        String json = JSONObject.toJSONString(t);
        request.source(json, XContentType.JSON);
        request.isRetry();
        request.opType(DocWriteRequest.OpType.INDEX);
        return restHighLevelClient.index(request, RequestOptions.DEFAULT);
    }

    @Override
    public <T> void putIndexAsync(T t, String index, String id, ESAsyncListener listenerResponse) {
        if (null == listenerResponse){
            throw new JsonResultException(JsonResultErrorEnum.T99999);
        }
        IndexRequest request = new IndexRequest(index);
        request.id(id);
        String json = JSONObject.toJSONString(t);
        request.source(json, XContentType.JSON);
        request.isRetry();
        request.opType(DocWriteRequest.OpType.INDEX);
        restHighLevelClient.indexAsync(request, RequestOptions.DEFAULT, new ActionListener<IndexResponse>() {
            @Override
            public void onResponse(IndexResponse indexResponse) {
                listenerResponse.indexAsyncSuccess(indexResponse);
            }

            @Override
            public void onFailure(Exception e) {
                listenerResponse.indexAsyncFailure(e);
            }
        });
    }

    @Override
    public <T> T get(T response, String index, String id) throws IOException {
        GetRequest getRequest = new GetRequest(index,id);
        GetResponse getResponse = restHighLevelClient.get(getRequest,RequestOptions.DEFAULT);
        Map<String, Object> source = getResponse.getSource();
        try {
            BeanUtils.populate(response,source);
        } catch (Exception e) {
            log.info("搜索转换Bean出错,index:{},id:{}",index,id,e);
        }
        return response;
    }
}
