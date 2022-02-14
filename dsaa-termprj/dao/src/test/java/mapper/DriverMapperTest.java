package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.Driver;
import util.ApplicationUtil;
import util.MyBatisUtil;

import java.util.List;
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
        sqlSession.close();
    }

    @Test
    void register() {
//        Random random = new Random();
        long id = 83384123;
        String name = "司机小吴";
        String pwd = ApplicationUtil.encryptPwd("123456");
        int drivingAge = 5;
        Assertions.assertEquals(driverMapper.register(id, name, pwd, drivingAge), 1);
        id = 83312345;
        name = "司机老吴";
        pwd = ApplicationUtil.encryptPwd("888888");
        drivingAge = 10;
        Assertions.assertEquals(driverMapper.register(id, name, pwd, drivingAge), 1);
    }

    @Test
    void login() {
        //先注册车，再登录司机！
        Driver driver = driverMapper.login(83384123, ApplicationUtil.encryptPwd("123456"));
        System.out.println(driver);
        System.out.println(driver.getCar());
        Assertions.assertNotNull(driver);
    }

    @Test
    void searchAll() {
        List<Driver> drivers = driverMapper.searchAll();
        for(Driver driver : drivers) {
            System.out.println(driver);
        }
    }
}