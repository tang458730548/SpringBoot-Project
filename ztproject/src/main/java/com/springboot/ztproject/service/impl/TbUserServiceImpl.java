package com.springboot.ztproject.service.impl;

import com.springboot.ztproject.dao.TbUserMapper;
import com.springboot.ztproject.pojo.TbUser;
import com.springboot.ztproject.service.BaseService;
import com.springboot.ztproject.service.TbUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class TbUserServiceImpl extends BaseServiceImpl<TbUser> implements TbUserService {

    public TbUserMapper tbUserMapper;

    @Resource
    private void setTbUserMapper(TbUserMapper tbUserMapper){
        myMapper = this.tbUserMapper = tbUserMapper;
    }

    /**
     * 根据用户姓名查询
     * @param username
     * @return
     */
    @Override
    public TbUser findByUserName (String username) {
        return tbUserMapper.findByUserName(username);
    }
}
