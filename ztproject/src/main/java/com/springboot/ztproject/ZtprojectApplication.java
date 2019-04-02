package com.springboot.ztproject;

import lombok.extern.slf4j.Slf4j;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.TemplateEngine;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.springboot.ztproject.dao")
@Slf4j
public class ZtprojectApplication {
    public static void main (String[] args) {
        SpringApplication.run (ZtprojectApplication.class, args);
        log.info ("-------------SpringBoot start successfully------------");
    }
}
