package com.channelsoft.study.cloud.butelmanageservice.controller;

import com.channelsoft.study.cloud.butelmanageservice.po.AjaxPo;
import com.channelsoft.study.cloud.butelmanageservice.po.ButelNumPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
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
    private RestTemplate restTemplate;

    /**
     * 测试正常的url调用
     * @return
     */
    @GetMapping("/butel-list")
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
    @GetMapping("/ret-list-timeout")
    public List<ButelNumPo> retListTimeout() {
        try {
            List<ButelNumPo> list = this.restTemplate.getForObject("http://butel-manage-service/butel/list-timeout", List.class);
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
     * 测试服务端主动抛异常
     * @return
     */
    @GetMapping("/ret-list-exception")
    public List<ButelNumPo> retListException() {
        try {
            List<ButelNumPo> list = this.restTemplate.getForObject("http://butel-manage-service/butel/exception", List.class);
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
     * 通过数组返回List类型的结果
     * @return
     */
    @GetMapping("/ret-list")
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
    @GetMapping("/ret-list1")
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
    @GetMapping("/ret-list2")
    public  AjaxPo<List<ButelNumPo>> retList2() {
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
}
