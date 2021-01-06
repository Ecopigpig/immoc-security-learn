package com.imooc.security.core.properties;

import java.io.Serializable;

/**
 * @program: immoc-security-learn
 * @description: 验证码属性（包括短信验证码 和 图形验证码）
 * @author: linxinting
 * @create: 2021-01-05 14:40
 **/
public class ValidateCodeProperties implements Serializable {

    private ImageCodeProperties image = new ImageCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}
