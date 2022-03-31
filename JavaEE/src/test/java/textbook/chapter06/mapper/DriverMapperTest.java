package textbook.chapter06.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import textbook.chapter06.po.Driver;
import textbook.chapter06.util.MyBatisUtils;

import java.util.List;

class DriverMapperTest {
    
    SqlSession sqlSession;
    DriverMapper driverMapper;
    
    @BeforeEach
    void setUp() {
        sqlSession = MyBatisUtils.getSqlSession();
        driverMapper = sqlSession.getMapper(DriverMapper.class);
    }
    
    @AfterEach
    void tearDown() {
        sqlSession.commit();
        sqlSession.close();
    }
    
    @Test
    void getAllDriver() {
        List<Driver> allDriver = driverMapper.getAllDrivers();
        for (Driver driver : allDriver) {
            System.out.println(driver);
        }
    }
    
    @Test
    void getDriverById() {
        Driver id001 = driverMapper.getDriverById("id001");
        System.out.println(id001);
    }
    
    @Test
    void insertDriver() {
        System.out.println(driverMapper.insertDriver("id003", "name111", 10));
    }
    
    @Test
    void deleteAllDrivers() {
        System.out.println(driverMapper.deleteAllDrivers());
    }
}