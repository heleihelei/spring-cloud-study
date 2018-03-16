package com.channelsoft.study.cloud.butelmanageservice.controller;

import com.channelsoft.study.cloud.butelmanageservice.po.User;
import com.channelsoft.study.cloud.butelmanageservice.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <dl>
 * <dt>CumsumerController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/12</dd>
 * </dl>
 *
 * @author cuihc
 */
@RestController
@RequestMapping("/consumer")
public class CumsumerController {

    Logger logger = LoggerFactory.getLogger(CumsumerController.class);

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return consumerService.hello(name);
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return consumerService.hello(name,age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return consumerService.hello(user);
    }

    @RequestMapping(value = "/hello4/{name}/{age}", method = RequestMethod.GET)
    public User hello4(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        return consumerService.hello4(name, age);
    }

    @RequestMapping(value = "/timeout", method = RequestMethod.GET)
    public String timeout() {
        return consumerService.timeout();
    }

}
