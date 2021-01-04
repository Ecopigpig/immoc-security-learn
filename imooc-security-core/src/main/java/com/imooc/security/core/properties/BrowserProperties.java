package com.imooc.security.core.properties;

/**
 * @program: immoc-security-learn
 * @description: 浏览器相关配置类
 * @author: linxinting
 * @create: 2021-01-04 15:06
 **/
public class BrowserProperties {

    private String loginPage = "/imooc-signIn.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}