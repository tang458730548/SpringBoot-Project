package com.springboot.ztproject.common.config;

import com.springboot.ztproject.vo.PageBean;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

    List<T> findByPage (PageBean<T> page);

    Integer getTotalCount(T t);
}