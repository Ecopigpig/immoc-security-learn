package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.web.dto.User;
import com.imooc.web.dto.UserQueryCondition;
import com.imooc.web.exception.UserNotExistException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: imooc-security
 * @description: 用户控制器
 * @author: linxinting
 * @create: 2020-11-10 16:06
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取登录用户的信息 3种方式
     * @param user
     * @return
     */
    @GetMapping("/me")
//    public Object getCurrentUser(){
//        return SecurityContextHolder.getContext().getAuthentication();
//    }
//    public Object getCurrentUser(Authentication authentication){
//        return authentication;
//    }
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user){
        return user;
    }

    @PostMapping
    @ApiOperation(value = "创建用户")
    public User create(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(
                    error -> {
//                        FieldError fieldError = (FieldError)error;
//                        String message = fieldError.getField() +" "+ error.getDefaultMessage();
//                        System.out.println(message);
                        System.out.println(error.getDefaultMessage());
                    }
            );
        }
        user.setId("1");
        System.out.println(ReflectionToStringBuilder.toString(user,ToStringStyle.MULTI_LINE_STYLE));
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        user.setId("1");
        System.out.println(ReflectionToStringBuilder.toString(user,ToStringStyle.MULTI_LINE_STYLE));
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println(id);
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition,@PageableDefault(page = 0, size =17,sort="username,asc") Pageable pageable){
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam(value = "用户id") @PathVariable String id){
//        throw new UserNotExistException(id);
        System.out.println("进入getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
    }
}
