package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.ApplicationUtil;
import util.MyBatisUtil;

class DriverMapperTest {

    SqlSession sqlSession;
    DriverMapper driverMapper;

    @BeforeEach
    void setUp() {
        sqlSession = MyBatisUtil.getSqlSession();
        driverMapper = sqlSession.getMapper(DriverMapper.class);
    }

    @AfterEach
    void tearDown() {
        sqlSession.close();
    }

    @Test
    void register() {
        String pwd = ApplicationUtil.encryptPwd("123456");
        Assertions.assertEquals(driverMapper.register(83384123, "司机小吴", pwd, 5), 1);
        pwd = ApplicationUtil.encryptPwd("888888");
        Assertions.assertEquals(driverMapper.register(83312345, "司机老吴", pwd, 10), 1);
    }

    @Test
    void login() {
        //先注册车，再登录司机！
        Assertions.assertEquals(driverMapper.login(83384123, ApplicationUtil.encryptPwd("123456")), 1);
    }

}