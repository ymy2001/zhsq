package com.zhsq.config;

import com.zhsq.interceptor.LoginCheckIntercepter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SpringBootApplication
@Slf4j
public class Webconfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckIntercepter loginCheckIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("注册拦截器");
        //配置拦截路径
        registry.addInterceptor(loginCheckIntercepter).addPathPatterns("/**").excludePathPatterns("/login")
                .excludePathPatterns("/register")
                .excludePathPatterns("/swagger");

    }
}
