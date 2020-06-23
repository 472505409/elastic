package com.zlc.elastic.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <p>
 *
 * </p>
 *
 * @Author zlc0w01
 * @Date 2020/6/4 19:33
 * @Version 1.0
 */
@Configuration
public class ESConfig {
    @Value("${es.config.ip:localhost}")
    private String ip;

    @Value("${es.config.port:8888}")
    private Integer port;

    @Value("${es.config.httpType:http}")
    private String httpType;

    @Bean
    @Scope("singleton")
    public HttpHost getHttpHost(){
        return new HttpHost(ip,port,httpType);
    }

    @Bean(initMethod = "init",destroyMethod = "close")
    public ESClientSpringFactory getFactory(){
        return ESClientSpringFactory.builder(getHttpHost());
    }

    @Bean("highLevelClient")
    public RestHighLevelClient getHLClient(){
        return getFactory().getRestHighLevelClient();
    }
}
