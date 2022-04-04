package p23MyBatis.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import p23MyBatis.pojo.User;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    
    SqlSessionTemplate sqlSessionTemplate;
    
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    
    @Override
    public List<User> getAllUsers() {
        return sqlSessionTemplate.getMapper(UserMapper.class).getAllUsers();
    }
    
    /**
     * 增加一个方法，用于测试声明式事务
     */
    @Override
    public int addUser(int id, String name, String pwd) {
        //故意多写一次insert，此时必然出错，因为重复插入相同主键的记录
        //注意，我们想要达到的效果是：如果第一次插入成功，第二次插入失败，那么数据库最终并不会插入新记录，数据库的状态和方法执行前的状态保持“一致”。
        sqlSessionTemplate.getMapper(UserMapper.class).addUser(id, name, pwd);
        return sqlSessionTemplate.getMapper(UserMapper.class).addUser(id, name, pwd);
    }
}
