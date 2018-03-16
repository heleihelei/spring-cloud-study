package com.channelsoft.study.cloud.butelmanageservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <dl>
 * <dt>ButelManageServiceApplication</dt>
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
@MapperScan("com.channelsoft.study.cloud.butelmanageservice.dao")
public class ButelManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ButelManageServiceApplication.class, args);
    }
}
