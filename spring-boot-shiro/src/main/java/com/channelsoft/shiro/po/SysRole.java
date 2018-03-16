package com.channelsoft.shiro.po;

import java.util.HashSet;
import java.util.Set;

/**
 * <dl>
 * <dt>SysRole</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/15</dd>
 * </dl>
 *
 * @author cuihc
 */
public class SysRole {
    private Long id; // 编号
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述,UI界面显示使用
    private Set<SysPermission> sysPermissionSet;

    public Set<SysPermission> getSysPermissionSet() {
        return sysPermissionSet;
    }

    public void setSysPermissionSet(Set<SysPermission> sysPermissionSet) {
        this.sysPermissionSet = sysPermissionSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static SysRole userRole() {
        SysPermission sysPermission = new SysPermission(1L, "用户查看", "/user/list","user:view");
        SysPermission sysPermission1 = new SysPermission(1L, "用户添加", "/user/add","user:add");
        SysRole sysRole = new SysRole();
        Set<SysPermission> sysPermissions = new HashSet<>();
        sysPermissions.add(sysPermission);
        sysPermissions.add(sysPermission1);
        sysRole.setSysPermissionSet(sysPermissions);
        sysRole.setId(1L);
        sysRole.setRole("用户权限");
        return sysRole;
    }
}
