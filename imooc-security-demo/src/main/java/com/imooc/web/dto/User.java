package com.imooc.web.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.web.validator.MyConstraint;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @program: imooc-security
 * @description: 用户实体类
 * @author: linxinting
 * @create: 2020-11-10 16:10
 **/
public class User {

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    private User create(User user){
        user.setId("1");
        return user;
    }

    private String id;

    @Past(message = "生日必须是过去的时间")
    private Date birthday;

    @MyConstraint(message = "这是一个测试")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
