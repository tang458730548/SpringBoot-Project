package com.springboot.ztproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页面控制器
 */
@Controller("IndexController")
public class IndexController {

    /**
     * 主页面控制器
     * @return
     */
    @RequestMapping(value = {"/index","/"})
    public String IndexPage(){
     return "login";
    }
}
