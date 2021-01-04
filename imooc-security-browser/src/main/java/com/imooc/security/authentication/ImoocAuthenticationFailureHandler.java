package com.imooc.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.security.core.properties.LoginType;
import com.imooc.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: immoc-security-learn
 * @description: 登录失败处理器
 * @author: linxinting
 * @create: 2021-01-04 16:16
 **/
@Component("imoocAuthenticationFailureHandler")
//public class ImoocAuthenticationFailureHandler implements AuthenticationFailureHandler {
/**
 * 改为继承Security默认的失败处理器
 */
public class ImoocAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("登录失败");

        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(e));
        }else{
            //不返回JSON就调用父类的方法，跳转到指定的页面
            super.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
        }


    }
}
