package com.springboot.ztproject.service;

import com.springboot.ztproject.pojo.TbUser;

public interface TbUserService extends BaseService<TbUser>{
    /**
     * 根据用户查询用户信息
     * @param username
     * @return
     */
    TbUser findByUserName (String username);
}
