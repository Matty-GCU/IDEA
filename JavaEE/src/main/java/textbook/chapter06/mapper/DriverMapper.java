package textbook.chapter06.mapper;

import org.apache.ibatis.annotations.Param;
import textbook.chapter06.po.Driver;

import java.util.List;

//@Mapper
public interface DriverMapper {
    
    List<Driver> getAllDrivers();
    
    Driver getDriverById(String id);
    
    int insertDriver(@Param("id") String id, @Param("name") String name, @Param("drivingAge") int drivingAge);
    
    int deleteAllDrivers();
}
