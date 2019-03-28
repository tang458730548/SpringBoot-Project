package com.springboot.ztproject.dao;

import com.springboot.ztproject.common.config.MyMapper;
import com.springboot.ztproject.pojo.TbUser;

import java.util.List;

public interface TbUserMapper extends MyMapper<TbUser>{

    TbUser findByUserName (String username);
}
