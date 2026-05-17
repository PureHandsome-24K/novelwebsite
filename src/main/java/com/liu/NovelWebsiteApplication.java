package com.liu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.liu.mapper")
@EnableAsync
public class NovelWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelWebsiteApplication.class, args);
    }

}
