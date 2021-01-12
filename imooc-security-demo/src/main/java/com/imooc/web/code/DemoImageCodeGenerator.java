package com.imooc.web.code;

import com.imooc.security.core.validate.code.ImageCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.IOException;

//先走自定义注入的bean，如下，如果没有才走自定义配置的bean，也就是ValidateCodeBeanConfig
//在不改动别人的代码（ValidateCodeBeanConfig）的同时，修改逻辑（自定义新的bean-DemoImageCodeGenerator），
/**
 * @program: immoc-security-learn
 * @description: 图片校验码生成器实现类
 * @author: linxinting
 * @create: 2021-01-06 09:48
 **/
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode createImageCode(HttpServletRequest request) throws IOException {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }

    @Override
    public Color getRandColor(int fc, int bc) {
        return null;
    }
}
