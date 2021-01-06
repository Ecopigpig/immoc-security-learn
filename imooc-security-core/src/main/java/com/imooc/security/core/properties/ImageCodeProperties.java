package com.imooc.security.core.properties;

import java.io.Serializable;

/**
 * @program: immoc-security-learn
 * @description: 图片属性
 * @author: linxinting
 * @create: 2021-01-05 14:37
 **/
public class ImageCodeProperties implements Serializable {

    private static final long serialVersionUID = 1372713713379974447L;
    /**
     * 应用级别的默认配置
     */
    private int width = 67;
    private int height = 23;
    private int length = 4;
    private int expireIn = 60;
    private String url;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
