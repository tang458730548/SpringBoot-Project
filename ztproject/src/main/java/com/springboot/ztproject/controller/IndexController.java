package com.springboot.ztproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @GetMapping(value="/index")
    public String index(){

        return "index";
    }
}
