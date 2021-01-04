package com.imooc.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.security.core.properties.LoginType;
import com.imooc.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: immoc-security-learn
 * @description: 登录成功处理器
 * @author: linxinting
 * @create: 2021-01-04 15:53
 **/
@Component("imoocAuthenticationSuccessHandler")
//public class ImoocAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
/**
 * 改为继承Security默认的成功处理器
 */
public class ImoocAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        logger.info("登录成功");

        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(authentication));
        }else{
            //不返回JSON就调用父类的方法，跳转到指定的页面
            super.onAuthenticationSuccess(httpServletRequest,httpServletResponse,authentication);
        }

    }
}
