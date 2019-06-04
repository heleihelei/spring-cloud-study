package com.channelsoft.study.cloud.butelmanageservice.service;

import com.channelsoft.study.cloud.butelmanageservice.po.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <dl>
 * <dt>ConsumerService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/12</dd>
 * </dl>
 *
 * @author cuihc
 */
//下面的值为需要调用服务的服务名
//@FeignClient(value = "butel-manage-service", fallback = ConsumerServiceFallback.class)
@FeignClient(value = "butel-manage-service", fallbackFactory = ConsumerServiceFallbackFactory.class)
public interface ConsumerService {

    @RequestMapping(value = "/butel/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/butel/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/butel/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) ;

    @RequestMapping(value = "/butel/hello4/{name}/{age}", method = RequestMethod.GET)
    public User hello4(@PathVariable("name") String name, @PathVariable("age") Integer age) ;

    @RequestMapping(value = "/butel/timeout", method = RequestMethod.GET)
    public String timeout() ;
}
