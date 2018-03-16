package com.channelsoft.study.cloud.butelmanageservice.controller;

import com.channelsoft.study.cloud.butelmanageservice.entity.ButelNum;
import com.channelsoft.study.cloud.butelmanageservice.exception.ServiceException;
import com.channelsoft.study.cloud.butelmanageservice.po.AjaxPo;
import com.channelsoft.study.cloud.butelmanageservice.po.ButelNumPo;
import com.channelsoft.study.cloud.butelmanageservice.po.User;
import com.channelsoft.study.cloud.butelmanageservice.service.ButelNumService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <dl>
 * <dt>ButelNumController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/8</dd>
 * </dl>
 *
 * @author cuihc
 */
@RestController
@RequestMapping("/butel")
public class ButelNumController {

    Logger logger = LoggerFactory.getLogger(ButelNumController.class);

    private static final String SUCCESS = "success";
    @Autowired
    private ButelNumService butelNumService;

    @ApiOperation(value="获取所有butel号码", notes="可以传入参数分页获取")
//    @ApiImplicitParam(name = "po", value = "butel号码资源实体", required = false, dataType = "com.channelsoft.study.cloud.butelmanageservice.po.ButelNumPo")
    @GetMapping("/list")
    public  List<ButelNum> list(ButelNumPo po, HttpServletRequest httpServletRequest) {
//        AjaxPo ret = new AjaxPo();
        List<ButelNum> list = butelNumService.list(po);
//        long total = butelNumService.total(po);
//        ret.setObj(list);
//        ret.setTotal(total);
        return list;
    }

    @GetMapping("/list-timeout")
    public  List<ButelNum> listTimeout(ButelNumPo po, HttpServletRequest httpServletRequest) {
        List<ButelNum> list = butelNumService.list(po);
        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }

    @GetMapping("/list-ajax")
    public AjaxPo<List<ButelNum>> list4AjaxPo(ButelNumPo po, HttpServletRequest httpServletRequest) {
        AjaxPo ret = new AjaxPo();
        List<ButelNum> list = butelNumService.list(po);
        long total = butelNumService.total(po);
        ret.setObj(list);
        ret.setTotal(total);
        return ret;
    }

    @RequestMapping("/add")
    public String add(ButelNumPo po, HttpServletRequest httpServletRequest) {
        butelNumService.insertButelNum(po);
        return SUCCESS;
    }

    @RequestMapping("/query")
    public ButelNumPo queryButel(ButelNumPo po, HttpServletRequest httpServletRequest) {
       return butelNumService.query(po);
    }

    @RequestMapping("/exception")
    public ButelNumPo testException(ButelNumPo po, HttpServletRequest httpServletRequest) {
        throw new ServiceException("test exception");
    }

    @ApiOperation(value="测试传入参数", notes="测试传入参数")
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "hello " + name;
    }

    @ApiOperation(value="测试传入参数", notes="测试传入参数")
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    /**
     * 此写法，默认是需要request中头部Content-Type:text/plain;charset=UTF-8，传入的json字符串
     * @param user
     * @return
     */
    @ApiOperation(value="测试传入参数", notes="测试传入参数")
    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return "hello " + user.getName() + ", " + user.getAge();
    }

    @ApiOperation(value="测试传入参数", notes="测试传入参数")
    @RequestMapping(value = "/hello4/{name}/{age}", method = RequestMethod.GET)
    public User hello4(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        return new User(name, age);
    }

    @ApiOperation(value="测试timeout", notes="测试timeout")
    @RequestMapping(value = "/timeout", method = RequestMethod.GET)
    public String timeout() {
        logger.info("进入timeout..........");
        try {
            Thread.sleep(5000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }


}
