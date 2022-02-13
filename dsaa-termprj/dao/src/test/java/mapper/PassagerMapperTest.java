package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.Passager;
import util.ApplicationUtil;
import util.MyBatisUtil;

import java.util.Random;


class PassagerMapperTest {

    SqlSession sqlSession;
    PassagerMapper passagerMapper;

    @BeforeEach
    void setUp() {
        sqlSession = MyBatisUtil.getSqlSession();
        passagerMapper = sqlSession.getMapper(PassagerMapper.class);
    }

    @AfterEach
    void tearDown() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void register() {
        Random random = new Random();
//        long id = 13417143272L;
        long id = random.nextLong();
        String name = "小吴";
        String pwd = ApplicationUtil.encryptPwd("123456");
        Assertions.assertEquals(passagerMapper.register(id, name, pwd), 1);
    }

    @Test
    void login() {
        Passager passager = passagerMapper.login(13417143272L, ApplicationUtil.encryptPwd("123456"));
        ApplicationUtil.setRandomLocation(passager);
        Assertions.assertNotNull(passager);
    }

}