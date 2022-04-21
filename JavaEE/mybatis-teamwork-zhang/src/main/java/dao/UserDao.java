package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import po.User;
import pojo.SelectUserById;

import java.util.List;

@Repository("userDao")
@Mapper
public interface UserDao {
	public SelectUserById selectUserById(Integer uid);
	public List<User> selectallUserAndBook();
}
