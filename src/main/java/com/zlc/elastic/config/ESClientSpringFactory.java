package com.zlc.elastic.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/4 20:09
 * @Version 1.0
 */
@Slf4j
public class ESClientSpringFactory {

    private static HttpHost HTTP_HOST;

    private RestHighLevelClient restHighLevelClient;

    private RestClientBuilder clientBuilder;

    private static ESClientSpringFactory FACTORY;

    public static ESClientSpringFactory builder(HttpHost httpHost){
        HTTP_HOST = httpHost;
        if (FACTORY == null){
            FACTORY = new ESClientSpringFactory();
            log.info("======>>>> es init ESClientSpringFactory OK!");
        }
        return FACTORY;
    }

    public RestHighLevelClient getRestHighLevelClient(){
        return this.restHighLevelClient;
    }

    public void init(){
        if (clientBuilder == null){
            clientBuilder = RestClient.builder(HTTP_HOST);
            log.info("======>>>> es init RestClientBuilder OK!");
        }
        if (restHighLevelClient == null){
            restHighLevelClient = new RestHighLevelClient(clientBuilder);
            log.info("======>>>> es init RestHighLevelClient OK!");
        }
        log.info("======>>>> es init ok!");
    }

    public void close(){
        if (restHighLevelClient != null){
            try {
                restHighLevelClient.close();
            } catch (IOException e) {
                log.info("关闭ES客户端restHighLevelClient失败",e);
            }
        }
        log.info("======>>>> es close ok!");
    }
}
