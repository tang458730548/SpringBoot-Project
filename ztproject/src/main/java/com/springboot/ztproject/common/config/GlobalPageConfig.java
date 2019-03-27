package com.springboot.ztproject.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 全局页面配置 404 500页面
 */

@Configuration
@Slf4j
public class GlobalPageConfig implements WebServerFactoryCustomizer {

    /**
     * SpringBoot 2.0以后通过实现WebServerFactoryCustomizer来配置
     * @param factory
     */
    @Override
    public void customize (WebServerFactory factory) {
        log.info ("----------- 配置customize开始 ------------");
        ConfigurableServletWebServerFactory factory1 = (ConfigurableServletWebServerFactory) factory;
        factory1.addErrorPages(new ErrorPage (HttpStatus.NOT_FOUND, "/404.html"));
        factory1.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html"));
        log.info ("----------- 配置customize结束 ------------");
    }
}
