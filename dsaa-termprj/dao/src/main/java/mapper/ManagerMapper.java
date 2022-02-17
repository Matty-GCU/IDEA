package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Manager;

public interface ManagerMapper {

    int register(@Param("id") String id, @Param("pwd") String pwd);

    Manager login(@Param("id") String id, @Param("pwd") String pwd);

}
