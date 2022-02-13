package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Driver;

public interface DriverMapper {

    int register(@Param("id") long id, @Param("name") String name, @Param("pwd") String pwd, @Param("drivingAge") int drivingAge);

    Driver login(@Param("id") long id, @Param("pwd") String pwd);

}
