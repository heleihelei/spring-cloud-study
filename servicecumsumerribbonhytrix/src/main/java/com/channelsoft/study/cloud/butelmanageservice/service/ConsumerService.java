package com.channelsoft.study.cloud.butelmanageservice.service;

import com.channelsoft.study.cloud.butelmanageservice.po.AjaxPo;
import com.channelsoft.study.cloud.butelmanageservice.po.ButelNumPo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
@Component
public class ConsumerService {
    Logger logger = LoggerFactory.getLogger(ConsumerService.class);


    @Autowired
    private RestTemplate restTemplate;

    /**
     * 测试正常的url调用
     * @return
     */
    public List<ButelNumPo> list() {
        try {
            List<ButelNumPo> list = this.restTemplate.getForObject("http://butel-manage-service/butel/list", List.class);
            return list;
        } catch (RestClientException e) {
            logger.info("进入RestClientException..." + e.getMessage());
            logger.info(e.getMessage(),e);
        } catch (Exception e1) {
            logger.info("进入Exception...");
            logger.info(e1.getMessage(),e1);
        }
        return null;
    }

    /**
     * 服务端超时设置
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public List<ButelNumPo> retListTimeout(String butelNum) {
        List<ButelNumPo> list = this.restTemplate.getForObject("http://butel-manage-service/butel/list-timeout", List.class);
        return list;
    }

    /**
     * 测试服务端主动抛异常
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public List<ButelNumPo> retListException(String butelNum) {
        List<ButelNumPo> list = this.restTemplate.getForObject("http://butel-manage-service/butel/exception", List.class);
        //下面不能直接获取po对象，会报异常
        for (ButelNumPo butelNumPo : list) {
            logger.info(butelNumPo.toString());
        }
        return list;
    }

    /**
     * 通过数组返回List类型的结果
     * @return
     */
    public List<ButelNumPo> retList() {
        try {
            ButelNumPo[] list = this.restTemplate.getForObject("http://butel-manage-service/butel/list", ButelNumPo[].class);
            //下面不能直接获取po对象，会报异常
            for (ButelNumPo butelNumPo : list) {
                logger.info(butelNumPo.toString());
            }
            List<ButelNumPo> alist = Arrays.asList(list);
            return alist;
        } catch (RestClientException e) {
            logger.info("进入RestClientException..." + e.getMessage());
            logger.info(e.getMessage(),e);
        } catch (Exception e1) {
            logger.info("进入Exception...");
            logger.info(e1.getMessage(),e1);
        }
        return null;
    }

    /**
     * 使用ParameterizedTypeReference 返回List类型的结果
     * @return
     */
    public List<ButelNumPo> retList1() {
        try {
            ResponseEntity<List<ButelNumPo>> responseEntity = restTemplate.exchange("http://butel-manage-service/butel/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<ButelNumPo>>() {
            });
            List<ButelNumPo> list = responseEntity.getBody();
            //下面不能直接获取po对象，会报异常
            for (ButelNumPo butelNumPo : list) {
                logger.info(butelNumPo.toString());
            }
            return list;
        } catch (RestClientException e) {
            logger.info("进入RestClientException..." + e.getMessage());
            logger.info(e.getMessage(),e);
        } catch (Exception e1) {
            logger.info("进入Exception...");
            logger.info(e1.getMessage(),e1);
        }
        return null;
    }

    /**
     * 使用ParameterizedTypeReference 返回复合对象的结果
     * @return
     */
    public AjaxPo<List<ButelNumPo>> retList2() {
        try {
            ResponseEntity<AjaxPo<List<ButelNumPo>>> responseEntity = restTemplate.exchange("http://butel-manage-service/butel/list-ajax", HttpMethod.GET, null, new ParameterizedTypeReference<AjaxPo<List<ButelNumPo>>>() {
            });
            AjaxPo<List<ButelNumPo>> ajaxPo = responseEntity.getBody();
            return ajaxPo;
        } catch (RestClientException e) {
            logger.info("进入RestClientException..." + e.getMessage());
            logger.info(e.getMessage(),e);
        } catch (Exception e1) {
            logger.info("进入Exception...");
            logger.info(e1.getMessage(),e1);
        }
        return null;
    }

    public List<ButelNumPo> fallback(String butelNum, Throwable e) {
        logger.info("butelNum=" + butelNum);
        logger.info("打印异常：" + e);
        ButelNumPo butelNumPo = new ButelNumPo();
        butelNumPo.setAppkey("exception");
        List<ButelNumPo> list = new ArrayList<>();
        list.add(butelNumPo);
        return list;
    }
}
