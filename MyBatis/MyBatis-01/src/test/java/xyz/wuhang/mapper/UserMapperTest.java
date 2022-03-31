package xyz.wuhang.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import xyz.wuhang.pojo.User;
import xyz.wuhang.utils.MyBatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserMapperTest {

    SqlSession sqlSession;
    UserMapper userMapper;

    @BeforeEach
    void initTest() {
        sqlSession = MyBatisUtils.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @AfterEach
    void closeTest() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    @DisplayName("缓存测试")
    void cacheTest() {
        SqlSession session1 = MyBatisUtils.getSqlSession();
        UserMapper mapper1 = session1.getMapper(UserMapper.class);
        User user1 = mapper1.getUserById(1);
//        session1.close();

        System.out.println("==============");
        SqlSession session2 = MyBatisUtils.getSqlSession();
        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        System.out.println("==============");
        mapper2.getUserById(1);
        mapper2.getUserById(1);
        mapper2.getUserById(1);
        mapper2.getUserById(1);
        mapper2.getUserById(1);
//        System.out.println(user1 == user2);
        System.out.println("==============");
        session2.close();
    }

    @Test
    void justATest() {
        List<User> list = userMapper.getUserLike("name");
        for(User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void getUserListTest() {
        List<User> list = userMapper.getUserList();
        for(User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void getUserByIdTest() {
        System.out.println(userMapper.getUserById(1));
    }

    @Test
    void addUserTest() {
        User user1 = new User(8, "name8", "pwd8");
        int result = userMapper.addUser(user1);
        System.out.println(result);
    }

    @Test
    void updateUserTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("newPwd", "123456789");
        map.put("userId", "8");
        System.out.println(userMapper.updateUser2(map));
    }

    @Test
    void deleteUserByIdTest() {
        System.out.println(userMapper.deleteUserById(5));
    }


}