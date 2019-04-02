package com.springboot.ztproject.controller.admin.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户控制器
 * @date 2019年3月30日15:40:19
 * @author tsc
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @GetMapping("/list")
    public String index(){
        return "admin/user/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public String list(){
        return null;
    }
}
