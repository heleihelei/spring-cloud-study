package com.channelsoft.study.cloud.butelmanageservice.controller;

import com.channelsoft.study.cloud.butelmanageservice.po.AjaxPo;
import com.channelsoft.study.cloud.butelmanageservice.po.ButelNumPo;
import com.channelsoft.study.cloud.butelmanageservice.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 测试正常的url调用
     * @return
     */
    @GetMapping("/butel-list")
    public List<ButelNumPo> list() {
      return consumerService.list();
    }

    /**
     * 服务端超时设置
     * @return
     */
    @GetMapping("/ret-list-timeout")
    public List<ButelNumPo> retListTimeout(String butelNum) {
       return consumerService.retListTimeout(butelNum);
    }

    /**
     * 测试服务端主动抛异常
     * @return
     */
    @GetMapping("/ret-list-exception")
    public List<ButelNumPo> retListException(String butelNum) {
       return consumerService.retListException(butelNum);
    }

    /**
     * 通过数组返回List类型的结果
     * @return
     */
    @GetMapping("/ret-list")
    public List<ButelNumPo> retList() {
       return consumerService.retList();
    }

    /**
     * 使用ParameterizedTypeReference 返回List类型的结果
     * @return
     */
    @GetMapping("/ret-list1")
    public List<ButelNumPo> retList1() {
       return consumerService.retList1();
    }

    /**
     * 使用ParameterizedTypeReference 返回复合对象的结果
     * @return
     */
    @GetMapping("/ret-list2")
    public  AjaxPo<List<ButelNumPo>> retList2() {
        return consumerService.retList2();
    }
}
