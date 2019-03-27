package com.springboot.ztproject.common.config;

import com.springboot.ztproject.common.inteceptor.MyInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器
 * @date 2019年3月27日16:55:12
 * @author tsc
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MyInteceptor myInteceptor;

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        //拦截/所有请求
        String[] paths = {"/*"};
        registry.addInterceptor (myInteceptor).addPathPatterns (paths);
    }
}
