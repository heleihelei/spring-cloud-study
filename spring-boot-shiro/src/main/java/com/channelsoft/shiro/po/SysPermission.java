package com.channelsoft.shiro.po;

/**
 * <dl>
 * <dt>SysPermission</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/15</dd>
 * </dl>
 *
 * @author cuihc
 */
public class SysPermission {

    private Long id; // 编号
    private String name;//名称.
    private String url;//资源路径.
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

    public SysPermission(Long id, String name, String url, String permission) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.permission = permission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}
