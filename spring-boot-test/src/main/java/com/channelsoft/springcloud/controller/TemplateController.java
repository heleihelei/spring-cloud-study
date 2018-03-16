package com.channelsoft.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
public class TemplateController {

    @RequestMapping("/")
    public String idx(ModelMap modelMap) {
        // 加入一个属性，用来在模板中读取
        modelMap.addAttribute("host", "http://www.channelsoft.com");
        // return模板文件的名称，对应src/main/resources/templates/ThymeleafTemplate.html
        return "ThymeleafTemplate";
    }
}
