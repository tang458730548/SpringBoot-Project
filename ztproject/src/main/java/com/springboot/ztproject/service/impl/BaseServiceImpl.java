package com.springboot.ztproject.service.impl;

import com.springboot.ztproject.common.config.MyMapper;
import com.springboot.ztproject.pojo.TbUser;
import com.springboot.ztproject.service.BaseService;
import com.springboot.ztproject.util.HttpResultUtil;
import com.springboot.ztproject.vo.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基础公共服务层实现
 * @param <T>
 * @date 2019年3月28日15:02:18
 * @author tsc
 */
@Service
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {

    public MyMapper<T> myMapper;

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey (Integer id) {
        return myMapper.deleteByPrimaryKey (id);
    }

    /**
     * 插入一条记录
     * @param t
     * @return
     */
    public int insert (T t) {
        return myMapper.insert (t);
    }

    /**
     * 插入可选字段
     * @param t
     * @return
     */
    public int insertSelective (T t) {
        return myMapper.insertSelective (t);
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public T selectByPrimaryKey (Integer id) {
        return myMapper.selectByPrimaryKey (id);
    }

    /**
     * 修改可选字段
     * @param t
     * @return
     */
    public int updateByPrimaryKeySelective (T t) {
        return myMapper.updateByPrimaryKeySelective (t);
    }

    /**
     * 根据主键修改
     * @param t
     * @return
     */
    public int updateByPrimaryKey (T t) {
        return myMapper.updateByPrimaryKey (t);
    }

    /**
     * 公共分页
     * @param page
     * @return
     */
    @Override
    public PageBean<T> findByPage (PageBean<T> page) {
        PageBean<T> pageBean = new PageBean<> ();
        List<T> list = myMapper.findByPage(page);
        pageBean.setDataList (list);
        return pageBean;
    }

    /**
     * 获取总页数
     *
     * @param t
     * @return
     */
    @Override
    public Integer getTotalCount (T t) {
        return myMapper.getTotalCount (t);
    }
}
