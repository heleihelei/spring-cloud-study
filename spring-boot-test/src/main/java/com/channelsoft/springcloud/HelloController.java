package com.channelsoft.springcloud;

import com.channelsoft.springcloud.config.TestProperties;
import com.channelsoft.springcloud.exception.JsonErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <dl>
 * <dt>HelloController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/13</dd>
 * </dl>
 *
 * @author cuihc
 */
@RestController
public class HelloController {

    @Autowired
    private TestProperties testProperties;

    @RequestMapping("/hello")
    public String index() {
        return "hello world";
    }

    @RequestMapping("/env")
    public String getEnv() {
        return testProperties.getName();
    }

    @RequestMapping("/exception")
    public String exception() {
        throw new RuntimeException("测试错误");
    }

    @RequestMapping("/json-exception")
    public String jsonException() throws JsonErrorException {
        throw new JsonErrorException("测试错误");
    }

}
