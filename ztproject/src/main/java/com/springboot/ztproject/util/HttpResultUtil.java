package com.springboot.ztproject.util;

import lombok.Data;

/**
 * 封装json返回结果集
 */
@Data
public class HttpResultUtil {

    /** 响应代码 */
    private Integer code ;
    /** 响应消息 */
    private String message;
    /** 返回data*/
    private Object data;
}
