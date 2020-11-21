package com.imooc.web.service.impl;

import com.imooc.web.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @program: imooc-security
 * @description: 服务实现类
 * @author: linxinting
 * @create: 2020-11-11 10:49
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        System.out.println();
        return "hello,"+ name;
    }
}
