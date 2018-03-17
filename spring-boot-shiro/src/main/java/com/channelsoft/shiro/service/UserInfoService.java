package com.channelsoft.shiro.service;

import com.channelsoft.shiro.po.SysRole;
import com.channelsoft.shiro.po.UserInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <dl>
 * <dt>UserInfoService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/15</dd>
 * </dl>
 *
 * @author cuihc
 */
@Service
public class UserInfoService {

    private static Map<String, UserInfo> map = new HashMap<>();

    static {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("admin");
        userInfo.setName("我是管理员");
        userInfo.setPassword("admin");
        userInfo.setSysRole(SysRole.userRole());
        map.put("admin", userInfo);

        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUsername("user");
        userInfo1.setName("我是默认用户");
        userInfo1.setPassword("user");
        userInfo1.setSysRole(SysRole.noneRole());
        map.put("user", userInfo1);
    }

    public UserInfo getUserInfoByName(String username) {
        return map.get(username);
    }
}
