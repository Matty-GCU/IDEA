package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.Passager;
import util.ApplicationUtil;
import util.MyBatisUtil;

import java.util.List;

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
        sqlSession.close();
    }

    @Test
    void register() {
        String pwd = ApplicationUtil.encryptPwd("123456");
        Assertions.assertEquals(passagerMapper.register(13417143272L, "小吴", pwd), 1);
        pwd = ApplicationUtil.encryptPwd("111111");
        Assertions.assertEquals(passagerMapper.register(15876597212L, "小黄", pwd), 1);
    }

    @Test
    void login() {
        Assertions.assertEquals(passagerMapper.login(13417143272L, ApplicationUtil.encryptPwd("123456")), 1);
        Assertions.assertEquals(passagerMapper.login(15876597212L, ApplicationUtil.encryptPwd("111111")), 1);
    }

    @Test
    void getAll() {
        List<Passager> allOnline = passagerMapper.getAllOnline();
        for(Passager passager : allOnline) {
            System.out.println(passager);
        }
    }

}