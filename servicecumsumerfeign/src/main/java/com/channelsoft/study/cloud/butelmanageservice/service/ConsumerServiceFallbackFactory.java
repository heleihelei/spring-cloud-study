package com.channelsoft.study.cloud.butelmanageservice.service;

import com.channelsoft.study.cloud.butelmanageservice.po.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <dl>
 * <dt>ConsumerServiceFallbackFactory</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2019</dd>
 * <dd>CreateDate: 2019年06月05日</dd>
 * </dl>
 *
 * @author 16649
 */
@Component
public class ConsumerServiceFallbackFactory implements FallbackFactory<ConsumerService> {
    public static final Logger logger = LoggerFactory.getLogger(ConsumerServiceFallbackFactory.class);
    
    @Override
    public ConsumerService create(Throwable throwable) {
        logger.error("ConsumerServiceFallbackFactory  error",throwable);
        return new ConsumerService() {
            @Override
            public String hello(String name) {
                return null;
            }

            @Override
            public User hello(String name, Integer age) {
                return null;
            }

            @Override
            public String hello(User user) {
                return null;
            }

            @Override
            public User hello4(String name, Integer age) {
                return new User("ConsumerServiceFallbackFactory error",15);
            }

            @Override
            public String timeout() {
                return null;
            }
        };
    }
}