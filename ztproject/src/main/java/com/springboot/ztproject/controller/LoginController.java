package com.springboot.ztproject.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.ztproject.pojo.TbUser;
import com.springboot.ztproject.util.CaptchaUtil;
import com.springboot.ztproject.util.HttpResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 登录控制器
 * @date 2019年3月27日17:08:51
 * @author tsc
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    /**
     * admin登录
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public HttpResultUtil login(String username, String password, String code , HttpSession session){
        HttpResultUtil httpResult = new HttpResultUtil ();
        if(StringUtils.isBlank (code) || null == code){
            httpResult.setCode (401);
            httpResult.setMessage ("验证码为空");
            return httpResult ;
        }
        if(session.getAttribute ("code") != null && code.equalsIgnoreCase ((String) session.getAttribute ("code"))){
            if (StringUtils.isBlank (username) || StringUtils.isBlank (password)) {
                httpResult.setCode (404);
                httpResult.setMessage ("没有此用户名");
                return httpResult;
            }
            Subject subject = SecurityUtils.getSubject ();
            try {
                subject.login (new UsernamePasswordToken (username, password));
            } catch (AuthenticationException ae) {
                log.error ("------------------------------- 登录失败 ------------------------------");
                httpResult.setCode (500);
                httpResult.setMessage ("用户名或者密码错误");
                return httpResult;
            }
            httpResult.setCode (200);
            httpResult.setMessage ("登录成功");
            TbUser tbUser = (TbUser) subject.getPrincipal ();
            httpResult.setData (JSONObject.toJSON (tbUser));
            log.info ("----------------------------------- 登录成功 -----------------------------");
            return httpResult;
        }else{
            httpResult.setCode (501);
            httpResult.setMessage ("验证码不正确");
            return httpResult ;
        }
    }

    @RequestMapping("/captcha")
    public void getCaptcha(HttpServletResponse response , HttpSession session){
        OutputStream out = null;
        try {
            // 设置响应类型
            response.setContentType ("image/jpg");
            // 获取创建验证码工具类实例
            CaptchaUtil yzm = CaptchaUtil.getInstance ();
            // 获取生成的验证码字符串
            String code = yzm.getCreateCode ();
            // 将验证码存放在session
            session.setAttribute ("code", code);
            // 获取验证码图片
            BufferedImage img = yzm.getCreateImg (code);
            try {
                out = response.getOutputStream ();
                ImageIO.write (img, "jpg", out);
                out.flush ();
            } catch (IOException e) {
                e.printStackTrace ();
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}
