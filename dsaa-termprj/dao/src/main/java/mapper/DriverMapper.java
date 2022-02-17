package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Driver;

import java.util.List;

public interface DriverMapper {

    /**
     * 司机注册
     */
    int register(@Param("id") long id, @Param("name") String name, @Param("pwd") String pwd, @Param("drivingAge") int drivingAge);

    /**
     * 司机登录，即开车上路接单（该司机必须拥有已注册车辆才能登录成功）
     */
    int login(@Param("id") long id, @Param("pwd") String pwd);

    List<Driver> getAllRegistered();

}
