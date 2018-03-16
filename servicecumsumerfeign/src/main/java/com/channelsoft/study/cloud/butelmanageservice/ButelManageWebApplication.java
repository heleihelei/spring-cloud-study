package com.channelsoft.study.cloud.butelmanageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

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
@EnableFeignClients
public class ButelManageWebApplication {


    public static void main(String[] args) {
        SpringApplication.run(ButelManageWebApplication.class, args);
    }
}
