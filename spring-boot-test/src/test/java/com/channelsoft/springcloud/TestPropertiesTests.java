package com.channelsoft.springcloud;

import com.channelsoft.springcloud.config.TestProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <dl>
 * <dt>TestPropertiesTests</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/13</dd>
 * </dl>
 *
 * @author cuihc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestPropertiesTests {

    @Autowired
    private TestProperties testProperties;

    @Test
    public void getHello() {
        Assert.assertEquals(testProperties.getName(), "张三");
        Assert.assertEquals(testProperties.getAge().toString(), "20");
        Assert.assertEquals(testProperties.getDescription(), "我是张三");
    }
}
