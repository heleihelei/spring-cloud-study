package com.channelsoft.study.cloud.butelmanageservice.po;

/**
 * <dl>
 * <dt>User</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/13</dd>
 * </dl>
 *
 * @author cuihc
 */
public class User {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
