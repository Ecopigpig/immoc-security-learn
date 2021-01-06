package com.imooc.security.core.validate.code;

import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @program: immoc-security-learn
 * @description: 校验码生成器
 * @author: linxinting
 * @create: 2021-01-06 09:29
 **/
public interface ValidateCodeGenerator {


    ImageCode createImageCode(HttpServletRequest request) throws IOException;

    Color getRandColor(int fc, int bc);
}
