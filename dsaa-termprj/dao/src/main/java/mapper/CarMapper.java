package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Car;

import java.util.List;

public interface CarMapper {

    /**
     * 车辆注册（拥有该车辆的司机必须提前注册自己的司机身份，否则无法注册该车辆）
     */
    int register(@Param("carId") String carId, @Param("driverId") long driverId);

    /**
     * 获取所有在线车辆
     */
    List<Car> getAllOnline();

}
