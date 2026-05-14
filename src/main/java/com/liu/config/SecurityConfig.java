package com.liu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //授权
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // 放行：anon 等价于 permitAll()
                        .requestMatchers("/","/tologin", "/index", "/index.html", "/login", "/noauthc").permitAll()

                        // 必须登录：authc 等价于 authenticated()
                        .requestMatchers("/Home").authenticated()

                        // 其他所有请求都必须登录
                        .anyRequest().authenticated()
                )

                // 未登录时跳转的登录页面
                .formLogin(form -> form
                        .loginPage("/")
                        .loginProcessingUrl("/login")
                        .failureUrl("/?error=true")
                        .successHandler((request, response, authentication) -> {
                            // 登录成功后将用户名存入 Session
                            request.getSession().setAttribute("username", authentication.getName());
                            // 重定向到首页
                            response.sendRedirect("/Home");
                        })
                        .permitAll()
                )

                // 权限不足时跳转的页面 → 对应 setUnauthorizedUrl("/noauthc")
                .exceptionHandling(ex -> ex
                        .accessDeniedPage("/noauthc")
                )

                // 登出放行
                .logout(logout -> logout.permitAll())

                // 前后端分离必关
                .csrf(csrf -> csrf.disable());

               //记住我功能
        http.rememberMe(rememberMe -> rememberMe
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(86400)
        );


        return http.build();
    }

    //密码加密
    @Bean//禁用了密码加密功能,要不然进不去
    public PasswordEncoder passwordEncoder(){
        return org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance();
    }


}
