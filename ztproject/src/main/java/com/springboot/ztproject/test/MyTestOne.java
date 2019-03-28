package com.springboot.ztproject.test;

import com.springboot.ztproject.dao.TbUserMapper;
import com.springboot.ztproject.pojo.TbUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MyTestOne {

    @Resource
    private TbUserMapper tbUserMapper;
    @Test
    public void test(){
    }

}
