package xyz.wuhang.mapper;

import xyz.wuhang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    //本来这里也可以写成updateUser(User user)的同名重载方法的，但是如果方法名相同，Mapper.xml里就会有两个update带有相同的id，这会导致报错
    int updateUser2(Map<String, Object> map);

    int deleteUserById(int id);

    //模糊查询
    List<User> getUserLike(String nameLike);
}
