package com.springboot.ztproject.controller.admin.user;

import com.springboot.ztproject.pojo.TbUser;
import com.springboot.ztproject.service.TbUserService;
import com.springboot.ztproject.util.HttpResultUtil;
import com.springboot.ztproject.vo.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 用户控制器
 * @date 2019年3月30日15:40:19
 * @author tsc
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Resource
    private TbUserService tbUserService;

    @GetMapping("/list")
    public String index(){
        return "admin/user/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public HttpResultUtil list(PageBean<TbUser> page ,TbUser tbUser ){
        HttpResultUtil result = new HttpResultUtil ();
        page.setPageIndex ((page.getPageNumber ()-1)*page.getPageSize ());
        page = tbUserService.findByPage(page);
        Integer totalCount = tbUserService.getTotalCount (tbUser);
        page.setTotalCount (totalCount);
        result.setCode (200);
        result.setMessage ("获取数据成功");
        result.setData (page);
        return result;
    }
}
