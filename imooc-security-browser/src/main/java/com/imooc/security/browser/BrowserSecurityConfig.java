package com.imooc.security.browser;

import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SpringSecurity配置
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler imoocAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * http://localhost:8070/index.html就是security的登录页地址
     * 只是当前我们做了自定义的登录页
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
////        http.formLogin()
//        http.httpBasic()
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated();

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(imoocAuthenticationFailureHandler);

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                //跳转不到这个页面的？？？？？？？
                .loginPage("/authentication/require")
//                .loginPage("/imooc-signIn.html")
                .loginProcessingUrl("/authentication/form")
                .successHandler(imoocAuthenticationSuccessHandler)
                .failureHandler(imoocAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage(),
                        "/code/image").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

    //配置内存用户
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder)
//                .withUser("jojo")
//                .password(encoder.encode("123456"))
//                .roles("ROOT", "USER")
//                .and()
//                .withUser("user")
//                .password(encoder.encode("123456"))
//                .roles("USER");
//    }
}
