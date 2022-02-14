package system;

import mapper.CarMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Car;
import util.MyBatisUtil;

import java.util.List;

public class BackgroundSystem {

    static List<Car> carList;

    static {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        carList = carMapper.searchAll();
        System.out.println(carList.getClass().getName());
    }

}
