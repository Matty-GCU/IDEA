package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Car;

import java.util.List;

public interface CarMapper {

    int register(@Param("carId") String carId, @Param("driverId") long driverId);

    List<Car> searchAll();
}
