package com.springboot.ztproject.service;

import com.springboot.ztproject.pojo.TbUser;
import com.springboot.ztproject.util.HttpResultUtil;
import com.springboot.ztproject.vo.PageBean;

/**
 * 基础公共服务层
 * @param <T>
 * @date 2019年3月28日15:02:18
 * @author tsc
 */
public interface BaseService<T> {

    int insert (T t);

    int insertSelective (T t);

    T selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (T t);

    int updateByPrimaryKey (T t);

    PageBean<T> findByPage (PageBean<T> page);

    Integer getTotalCount(T t);
}
