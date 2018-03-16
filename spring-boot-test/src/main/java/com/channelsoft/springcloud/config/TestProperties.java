package com.channelsoft.springcloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <dl>
 * <dt>TestProperties</dt>
 * <dd>Description:测试加载配置文件</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/13</dd>
 * </dl>
 *
 * @author cuihc
 */
@Component
public class TestProperties {

    @Value("${com.channelsoft.test.name}")
    private String name;

    @Value("${com.channelsoft.test.age}")
    private Integer age;

    @Value("${com.channelsoft.test.description}")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
