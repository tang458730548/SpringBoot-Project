package com.springboot.ztproject.pojo;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "t_user")
public class TbUser {
    /**�û�ID*/
    private Long userId;

    /**�û���*/
    private String username;

    /**����*/
    private String password;

    /**����ID*/
    private Long deptId;

    /**����*/
    private String email;

    /**��ϵ�绰*/
    private String mobile;

    /**״̬ 0���� 1��Ч*/
    private String status;

    /**����ʱ��*/
    private Date createTime;

    /**�޸�ʱ��*/
    private Date modifyTime;

    /**�������ʱ��*/
    private Date lastLoginTime;

    /**�Ա� 0�� 1Ů 2����*/
    private String ssex;

    /**����*/
    private String description;

    /**�û�ͷ��*/
    private String avatar;

}