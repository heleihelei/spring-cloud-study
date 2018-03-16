package com.channelsoft.shiro;

import com.channelsoft.shiro.po.SysPermission;
import com.channelsoft.shiro.po.UserInfo;
import com.channelsoft.shiro.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <dl>
 * <dt>MyShiroRealm</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/15</dd>
 * </dl>
 *
 * @author cuihc
 */
public class MyShiroRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("MyShiroRealm.doGetAuthorizationInfo()...");
        UserInfo userInfo  = (UserInfo)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole(userInfo.getSysRole().getRole());
        for (SysPermission sysPermission : userInfo.getSysRole().getSysPermissionSet()) {
            authorizationInfo.addStringPermission(sysPermission.getPermission());
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("MyShiroRealm.doGetAuthenticationInfo()...");
        //获取用户的输入的账号.
        String username = (String)authenticationToken.getPrincipal();
        UserInfo userInfo = userInfoService.getUserInfoByName(username);
        if (userInfo == null) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userInfo,userInfo.getPassword(), getName());
        return simpleAuthenticationInfo;
    }
}
