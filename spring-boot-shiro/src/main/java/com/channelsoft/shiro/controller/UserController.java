package com.channelsoft.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/list")
    @RequiresPermissions("user:view")
    public String list() {
        logger.info("进入UserController.list()...");
        return "user/list";
    }

    @RequestMapping("/add")
    public String add() {
        logger.info("进入UserController.add()...");
        return "user/add";
    }
}
