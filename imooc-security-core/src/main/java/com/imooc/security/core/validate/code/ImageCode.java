package com.imooc.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: immoc-security-learn
 * @description: 图形验证码
 * @author: linxinting
 * @create: 2021-01-05 09:58
 **/
public class ImageCode implements Serializable {

    private static final long serialVersionUID = -3865024949578326109L;

    private BufferedImage image;

    private String code;

    private LocalDateTime expireTime;


    /**
     * 过期的时间expireIn是秒数
     * @param image
     * @param code
     * @param expireIn
     */
    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public boolean isExpired(){
        //当前时间是在过期时间之后，则为true，判定为已经过期
        return LocalDateTime.now().isAfter(expireTime);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
