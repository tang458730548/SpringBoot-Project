package com.springboot.ztproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.springboot.ztproject.dao")
public class ZtprojectApplication {

    public static void main (String[] args) {
        SpringApplication.run (ZtprojectApplication.class, args);
    }

}
