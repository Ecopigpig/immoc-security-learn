package com.imooc.web.dto;

/**
 * @program: imooc-security
 * @description: 请求实体
 * @author: linxinting
 * @create: 2020-11-10 16:25
 **/
public class UserQueryCondition {
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
