package com.channelsoft.study.cloud.butelmanageservice.service;

import com.channelsoft.study.cloud.butelmanageservice.po.User;
import org.springframework.stereotype.Component;

/**
 * <dl>
 * <dt>ConsumerServiceFallback</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/13</dd>
 * </dl>
 *
 * @author cuihc
 */
@Component
public class ConsumerServiceFallback implements ConsumerService{
    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }

    @Override
    public User hello4(String name, Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String timeout() {
        return "error";
    }
}
