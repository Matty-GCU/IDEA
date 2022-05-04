package com.example.springbootmybatis;

import com.example.springbootmybatis.mapper.UserMapper;
import com.example.springbootmybatis.entity.User;
import com.example.springbootmybatis.mapper.UserMapper2XML;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {
    
    @Autowired
    UserMapper userMapper;
    
    @Autowired
    UserMapper2XML userMapper2XML;
    
    @Test
    void myBatisTest() {
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
    
    @Test
    void myBatisTest2() {
        List<User> all = userMapper2XML.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
    
}
