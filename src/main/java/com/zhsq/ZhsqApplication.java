package com.zhsq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication//(scanBasePackages = "com.zhsq.dao")
public class ZhsqApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhsqApplication.class, args);
        log.info("服务启动");
    }

}
