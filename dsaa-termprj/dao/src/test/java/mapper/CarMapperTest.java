package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.Car;
import util.MyBatisUtil;

import java.util.List;

class CarMapperTest {
    SqlSession sqlSession;
    CarMapper carMapper;

    @BeforeEach
    void setUp() {
        sqlSession = MyBatisUtil.getSqlSession();
        carMapper = sqlSession.getMapper(CarMapper.class);
    }

    @AfterEach
    void tearDown() {
        sqlSession.close();
    }

    @Test
    void register() {
        //先注册司机！再注册车！
        Assertions.assertEquals(carMapper.register("粤A-83384", 83384123), 1);
        Assertions.assertEquals(carMapper.register("粤A-1234510", 83312345), 1);
    }

    @Test
    void selectAll() {
        List<Car> allOnline = carMapper.getAllOnline();
        for(Car car : allOnline) {
            System.out.println(car);
        }
    }

}