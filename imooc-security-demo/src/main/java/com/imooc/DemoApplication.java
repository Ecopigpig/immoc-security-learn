package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: imooc-security
 * @description: 启动类
 * @author: linxinting
 * @create: 2020-11-10 15:18
 **/
@SpringBootApplication
@RestController
//访问地址：http://localhost:8070/swagger-ui.html
@EnableSwagger2
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
