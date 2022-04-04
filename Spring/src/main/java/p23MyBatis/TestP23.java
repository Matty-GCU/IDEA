package p23MyBatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import p23MyBatis.mapper.UserMapper;
import p23MyBatis.pojo.User;

import java.util.List;

public class TestP23 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("p23MyBatis/applicationContext.xml");
        // 实现方式一
        UserMapper userMapper = applicationContext.getBean("userMapperImpl", UserMapper.class);
        // 实现方式二
//         UserMapper userMapper = applicationContext.getBean("userMapperImpl2", UserMapper.class);

//        List<User> users = userMapper.getAllUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }
        
        //事务测试
        userMapper.addUser(9, "name9", "pwd9");
    }
}
