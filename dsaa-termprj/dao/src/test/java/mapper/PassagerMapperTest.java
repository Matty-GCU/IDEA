package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.Passager;
import util.ApplicationUtil;
import util.MyBatisUtil;

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
//        Random random = new Random();
        long id = 13417143272L;
        String name = "小吴";
        String pwd = ApplicationUtil.encryptPwd("123456");
        Assertions.assertEquals(passagerMapper.register(id, name, pwd), 1);
        id = 15876597212L;
        name = "小黄";
        pwd = ApplicationUtil.encryptPwd("111111");
        Assertions.assertEquals(passagerMapper.register(id, name, pwd), 1);
    }

    @Test
    void login() {
        Passager passager = passagerMapper.login(13417143272L, ApplicationUtil.encryptPwd("123456"));
        Assertions.assertNotNull(passager);
        ApplicationUtil.setRandomLocation(passager);
        passager = passagerMapper.login(15876597212L, ApplicationUtil.encryptPwd("111111"));
        Assertions.assertNotNull(passager);
        ApplicationUtil.setRandomLocation(passager);
    }

}