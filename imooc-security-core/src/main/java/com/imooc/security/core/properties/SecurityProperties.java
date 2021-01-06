package com.imooc.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: immoc-security-learn
 * @description: Secuirty相关配置类
 * @author: linxinting
 * @create: 2021-01-04 15:06
 **/
@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {

    BrowserProperties browser = new BrowserProperties();

    ValidateCodeProperties code = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
