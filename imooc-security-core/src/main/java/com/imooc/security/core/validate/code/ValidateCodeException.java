package com.imooc.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @program: immoc-security-learn
 * @description: 自定义校验处理
 * @author: linxinting
 * @create: 2021-01-05 10:34
 **/
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
