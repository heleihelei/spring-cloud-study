package com.channelsoft.study.cloud.butelmanageservice.controller;

import com.channelsoft.study.cloud.butelmanageservice.po.AjaxPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * <dl>
 * <dt>ButelController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/8</dd>
 * </dl>
 *
 * @author cuihc
 */
@RestController
public class ButelController {

    Logger logger = LoggerFactory.getLogger(ButelController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/butel-list")
    public AjaxPo list() {
        try {
            return this.restTemplate.getForObject("http://butel-manage-service/butel/list", AjaxPo.class);
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
