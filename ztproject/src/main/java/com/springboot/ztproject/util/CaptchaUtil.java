package com.springboot.ztproject.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码工具类
 * 文件名：CaptchaUtil.java
 */
public class CaptchaUtil {

    private Integer width;//验证码图片宽度
    private Integer height;//验证吗图片高度
    private Integer num;//验证码的个数
    private String code;//生成验证码一组字符串

    private static final Random ran = new Random();//随机数
    private static CaptchaUtil captchaUtil;

    /**
     * 通过默认构造初始化参数
     */
    private CaptchaUtil (){
        width = 80;
        height = 30;
        code = "123456789adcdefghijklmnopqrstuvwxyz";
        num = 4;
    }

    /**
     * 利用单利模式创建该验证码工具类
     * @return
     */
    public static CaptchaUtil getInstance(){
        if(captchaUtil==null){
            captchaUtil=new CaptchaUtil();
        }
        return captchaUtil;
    }
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static Random getRan() {
        return ran;
    }

    public void setCaptchaUtil(Integer width,Integer height,Integer num,String code){
        this.width=width;
        this.height=height;
        this.num=num;
        this.code=code;
    }

    public void setCaptchaUtil(Integer width,Integer height,String code){
        this.width=width;
        this.height=height;
        this.code=code;
    }
    /**
     * 随机生成验证码
     * @param code 生成验证码的一组字符串
     * @return
     */
    public String getCreateCode(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append(code.charAt(ran.nextInt(code.length())));
        }
        return sb.toString();
    }

    /**
     * 生成buffere Image图片
     * @param finshCode 生成好的验证码字符串
     * @return
     */
    public BufferedImage getCreateImg(String finshCode){
        // 创建BufferedImage对象
        BufferedImage img = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphic = img.createGraphics();// 创建画笔
        graphic.setColor(Color.WHITE);// 设置颜色
        graphic.fillRect(0, 0, width, height);//是用预定的颜色填充一个矩形，得到一个着色的矩形块。
        graphic.setColor(new Color(213, 213, 213));//设置边框颜色
        graphic.drawRect(0, 0, width - 1, height - 1);// 画正方形
        // 设置字体 风格 风格 高度
        Font font = new Font("宋体", Font.BOLD + Font.ITALIC,(int) (height * 0.8));
        graphic.setFont(font);
        for (int i = 0; i < num; i++) {
            // 随机设置字体RGB颜色
            graphic.setColor(new Color(ran.nextInt(200), ran.nextInt(200),ran.nextInt(200)));
            // 画出验证码
            graphic.drawString(String.valueOf(finshCode.charAt(i)), i* (width / num) + 4, (int) (height * 0.8));
        }
        for (int i = 0; i < (width + height); i++) {
            // 随机设置字体RGB颜色
            graphic.setColor(new Color(ran.nextInt(255), ran.nextInt(255),ran.nextInt(255)));
            // 生成干扰点
            graphic.drawOval(ran.nextInt(width), ran.nextInt(height), 1, 1);
        }
        for(int i = 0; i < 3; i++){
            // 随机设置字体RGB颜色
            graphic.setColor(new Color(ran.nextInt(255), ran.nextInt(255),ran.nextInt(255)));
            // 随机生成干扰线
            graphic.drawLine(0, ran.nextInt(height), width,ran.nextInt(height));
        }
        return img;
    }
}
