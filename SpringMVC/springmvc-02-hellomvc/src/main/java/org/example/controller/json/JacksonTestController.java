package org.example.controller.json;

import org.example.controller.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
//@ResponseBody
// 上面这两个注解可以“合二为一”，用一个@RestController注解代替
@RestController
@RequestMapping("/json2")
public class JacksonTestController {
    
    /**
     * 普通对象转换
     */
    @RequestMapping("/test1")
    public String test1() throws JsonProcessingException {
        User user = new User("1", "Wick", 35);
        ObjectMapper objectMapper = new ObjectMapper();
        // 关于String writeValueAsString(Object value)方法：
        // Method that can be used to serialize any Java value as a String.
        // 一句话：通过【序列化】将Java对象转化为纯字符串！
        String s = objectMapper.writeValueAsString(user);
        return s;
    }
    
    /**
     * 集合对象转换
     */
    @RequestMapping("/test2")
    public String test2() throws JsonProcessingException {
        List<User> userList = new ArrayList<>();
        User user1 = new User("1", "John", 35);
        User user2 = new User("2", "Wick", 35);
        User user3 = new User("3", "John Wick", 35);
        User user4 = new User("4", "Baba Yaga", 35);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(userList);
        return s;
    }
    
    /**
     * 日期对象转换
     */
    @RequestMapping("/test3")
    public String test3() throws JsonProcessingException {
        Date date = new Date();
        ObjectMapper objectMapper = new ObjectMapper();
        
        // 若objectMapper没有设置DateFormat，得到的会是时间戳(timestamp)格式的数据，等同于下面两行代码的输出：
        // System.out.println(date.getTime());
        // System.out.println(System.currentTimeMillis());
    
        // 注意MM是月份，mm是分钟；HH是24小时制的小时，hh是12小时制的小时
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String s = objectMapper.writeValueAsString(date);
        return s;
    }
}
