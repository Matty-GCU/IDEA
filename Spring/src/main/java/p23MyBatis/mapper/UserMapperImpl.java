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
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.getAllUsers();
    }
}
