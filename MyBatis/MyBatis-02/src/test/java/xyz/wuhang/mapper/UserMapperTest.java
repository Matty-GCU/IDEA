package xyz.wuhang.mapper;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
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

    @Test
    void getAllUsers() {
        List<User> list = userMapper.getUserList();
        for(User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void limitTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 5);
        List<User> list = userMapper.getUserByLimit(map);
        for(User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void rowBoundsTest() {
        RowBounds rowBounds = new RowBounds(1, 2);
        List<User> list = sqlSession.selectList("xyz.wuhang.mapper.UserMapper.getUserByRowBounds", null, rowBounds);
        for(User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void selectAnnotationTest() {
//        List<User> list = userMapper.getUserListByAnnotation();
//        for(User user : list) {
//            System.out.println(user);
//        }
        System.out.println(userMapper.getUserByID(1));
    }

    static Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    void log4jTest() {
        logger.info("info: log4jTest");
        logger.debug("debug: log4jTest");
        logger.error("error: log4jTest");
    }

    @AfterEach
    void closeTest() {
        sqlSession.commit();
        sqlSession.close();
    }

}