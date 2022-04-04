package p23MyBatis.mapper;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import p23MyBatis.pojo.User;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> getAllUsers() {
        return getSqlSession().getMapper(UserMapper.class).getAllUsers();
    }
    
    /**
     * 增加一个方法，用于测试声明式事务
     */
    @Override
    public int addUser(int id, String name, String pwd) {
        //未实现
        return 0;
    }
}
