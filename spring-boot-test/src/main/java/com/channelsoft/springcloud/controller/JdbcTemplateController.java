package com.channelsoft.springcloud.controller;

import com.channelsoft.springcloud.po.ButelNum;
import com.channelsoft.springcloud.service.ButelNumRepository;
import com.channelsoft.springcloud.service.ButelNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <dl>
 * <dt>JdbcTemplateController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/14</dd>
 * </dl>
 *
 * @author cuihc
 */
@RestController
@RequestMapping("/butel")
public class JdbcTemplateController {

    @Autowired
    private ButelNumService butelNumService;

    @Autowired
    private ButelNumRepository butelNumRepository;

    @RequestMapping("/jdbclist")
    public List<ButelNum> list() {
        return butelNumService.list(null);
    }

    @RequestMapping("/jpalist")
    public List<ButelNum> jpalist() {
        return butelNumRepository.findAll();
    }
}
