package xyz.wuhang.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.wuhang.mapper.UserMapper;
import xyz.wuhang.pojo.User;
import xyz.wuhang.utils.MyBatisUtils;

import java.util.List;

class UserMapperTest {

    SqlSession sqlSession;
    UserMapper userMapper;

    @BeforeEach
    void initTest() {
        sqlSession = MyBatisUtils.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
    
    @Test
    void getUserListTest() {
        List<User> list = userMapper.getUserList();
        for(User user : list) {
            System.out.println(user);
        }
    }

    @AfterEach
    void closeTest() {
        sqlSession.commit();
        sqlSession.close();
    }

}