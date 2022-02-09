package xyz.wuhang.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.wuhang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserList();

    List<User> getUserByLimit(Map<String, Integer> map);

    List<User> getUserByRowBounds();

    @Select("select * from mybatis.user")
    List<User> getUserListByAnnotation();

    User getUserByID(@Param("user_id") int id);

}
