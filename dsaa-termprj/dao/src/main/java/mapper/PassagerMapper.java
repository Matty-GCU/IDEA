package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Passager;

import java.util.List;

public interface PassagerMapper {

    /**
     * 乘客注册
     */
    int register(@Param("id") long id, @Param("name") String name, @Param("pwd") String pwd);

    /**
     * 乘客登录，即开始约车
     */
    int login(@Param("id") long id, @Param("pwd") String pwd);

    /**
     * 获取所有在线乘客
     */
    List<Passager> getAllOnline();
}
