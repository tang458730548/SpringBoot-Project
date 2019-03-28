package com.springboot.ztproject.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class IndexController {

    @GetMapping(value="/index")
    public String index(){

        return "admin/index";
    }

    @GetMapping(value = "/main")
    public String main(){
        return "admin/main";
    }
}
