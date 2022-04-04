package p23MyBatis.mapper;

import org.apache.ibatis.annotations.Param;
import p23MyBatis.pojo.User;
import java.util.List;

public interface UserMapper {
    
    List<User> getAllUsers();
    
    /**
     * 增加一个方法，用于测试声明式事务
     */
    int addUser(@Param("id") int id, @Param("name") String name, @Param("pwd") String pwd);
    
}
