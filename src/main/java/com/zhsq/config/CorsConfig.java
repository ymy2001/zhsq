package com.zhsq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*
* 跨域资源共享（CORS）是一种基于 HTTP 头的机制，
* 它允许服务器指示除自己以外的任何来源（域、方案或端口），
* 浏览器应该允许从这些来源加载资源。CORS 还依赖于一种机制，
* 即浏览器向托管跨域资源的服务器发出“预检”请求，以检查服务器是否允许实际请求。
* 在预检请求中，浏览器会发送指示实际请求中将使用的 HTTP 方法和头的头部。
* */
@Configuration
@Slf4j
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        log.info("注册跨域请求组件");
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(source);
    }
}
