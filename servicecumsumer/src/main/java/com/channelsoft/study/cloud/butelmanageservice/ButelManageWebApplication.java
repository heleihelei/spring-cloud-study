package com.channelsoft.study.cloud.butelmanageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * <dl>
 * <dt>ButelManageWebApplication</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/8</dd>
 * </dl>
 *
 * @author cuihc
 */
@SpringBootApplication
@EnableEurekaClient
public class ButelManageWebApplication {

   /* @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }*/

    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(3000);
        httpRequestFactory.setConnectTimeout(3000);
        httpRequestFactory.setReadTimeout(3000);

        return new RestTemplate(httpRequestFactory);
    }

    public static void main(String[] args) {
        SpringApplication.run(ButelManageWebApplication.class, args);
    }
}
