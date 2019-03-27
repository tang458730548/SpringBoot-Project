package com.springboot.ztproject.controller;

import com.springboot.ztproject.util.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class LoginController {

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
