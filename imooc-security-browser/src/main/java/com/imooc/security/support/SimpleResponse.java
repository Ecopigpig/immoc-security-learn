package com.imooc.security.support;

import java.io.Serializable;

/**
 * @program: immoc-security-learn
 * @description: 自定义返回数据结构体
 * @author: linxinting
 * @create: 2021-01-04 14:58
 **/
public class SimpleResponse implements Serializable {

    private static final long serialVersionUID = -8159072264275727491L;

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
