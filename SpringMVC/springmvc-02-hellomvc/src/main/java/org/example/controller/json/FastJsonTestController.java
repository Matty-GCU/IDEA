package org.example.controller.json;

import com.alibaba.fastjson.JSONObject;
import org.example.controller.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 实现与JacksonTestController一模一样的功能，看看用Fastjson在实现上会有什么区别
 */
@RestController
@RequestMapping("/json3")
public class FastJsonTestController {
    
    /**
     * 普通对象转换
     */
    @RequestMapping("/test1")
    public String test1() {
        User user = new User("1", "Wick", 35);
        String s = JSONObject.toJSONString(user);
        return s;
    }
    
    /**
     * 集合对象转换
     */
    @RequestMapping("/test2")
    public String test2() {
        List<User> userList = new ArrayList<>();
        User user1 = new User("1", "John", 35);
        User user2 = new User("2", "Wick", 35);
        User user3 = new User("3", "John Wick", 35);
        User user4 = new User("4", "Baba Yaga", 35);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        String s = JSONObject.toJSONString(userList);
        return s;
    }
    
    /**
     * 日期对象转换
     */
    @RequestMapping("/test3")
    public String test3() {
        Date date = new Date();
        String s = JSONObject.toJSONString(date);
        return s;
    }
}
