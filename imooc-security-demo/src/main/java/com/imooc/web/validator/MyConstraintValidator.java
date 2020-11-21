package com.imooc.web.validator;

import com.imooc.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @program: imooc-security
 * @description: 自定义校验类 实现了ConstraintValidator会自动转化成bean容器，因此不再需要添加注解@Component
 * 该校验器可以注入spring里面的所有东西
 * @author: linxinting
 * @create: 2020-11-11 10:45
 **/
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloService.greeting("tom");
        System.out.println("这是真正的校验逻辑");
        System.out.println(o+"是需要校验的值，"+constraintValidatorContext+"需要校验的上下文");
        System.out.println("true是校验通过，false是校验失败");
        return false;
    }

}
