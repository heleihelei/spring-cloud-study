package com.channelsoft.study.cloud.butelmanageservice.controller;

import com.channelsoft.study.cloud.butelmanageservice.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <dl>
 * <dt>SourceController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/9</dd>
 * </dl>
 *
 * @author cuihc
 */
@RestController
@RequestMapping("/source")
public class SourceController {
    @Autowired
    private SourceService sourceService;

    @RequestMapping("/add")
    public void add() {

    }

}
