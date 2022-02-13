package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Passager;

public interface PassagerMapper {

    int register(@Param("id") long id, @Param("name") String name, @Param("pwd") String pwd);

    Passager login(@Param("id") long id, @Param("pwd") String pwd);
}
