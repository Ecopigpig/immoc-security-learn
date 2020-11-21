package com.imooc.web.exception;

import java.io.Serializable;

/**
 * @program: imooc-security
 * @description: 用户不存在异常
 * @author: linxinting
 * @create: 2020-11-13 15:22
 **/
public class UserNotExistException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1279971646941974805L;

    private String id;

    public UserNotExistException(String id){
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
