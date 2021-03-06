package com.imooc.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: imooc-security
 * @description: 时间拦截器
 * @author: linxinting
 * @create: 2020-11-13 17:57
 **/
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        System.out.println("preHandle");
        httpServletRequest.setAttribute("startTime",System.currentTimeMillis());
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getClass().getName());
        //当preHandle返回的是false时，不会执行postHandle，当返回值是true时，才会走postHandle方法
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        Long start = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时："+(System.currentTimeMillis() -  start));
    }

    /**
     * 最终一定会走这个方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
        Long start = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时："+(System.currentTimeMillis() -  start));
        System.out.println("ex is "+e);
    }
}
