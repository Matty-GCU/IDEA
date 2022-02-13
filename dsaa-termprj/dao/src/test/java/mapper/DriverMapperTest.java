package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.Driver;
import util.ApplicationUtil;
import util.MyBatisUtil;

import java.util.Random;

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
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void register() {
        Random random = new Random();
//        long id = 83384123;
        long id = random.nextLong();
        String name = "司机小杭";
        String pwd = ApplicationUtil.encryptPwd("456789");
        int drivingAge = 5;
        Assertions.assertEquals(driverMapper.register(id, name, pwd, drivingAge), 1);
    }

    @Test
    void login() {
        Driver driver = driverMapper.login(83384123, ApplicationUtil.encryptPwd("456789"));
        Assertions.assertNotNull(driver);
    }
}