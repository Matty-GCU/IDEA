package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Driver;

import java.util.List;

public interface DriverMapper {

    /**
     * insert
     */
    int register(@Param("id") long id, @Param("name") String name, @Param("pwd") String pwd, @Param("drivingAge") int drivingAge);

    /**
     * select one record
     */
    Driver login(@Param("id") long id, @Param("pwd") String pwd);

    /**
     * select all records
     */
    List<Driver> searchAll();

}
