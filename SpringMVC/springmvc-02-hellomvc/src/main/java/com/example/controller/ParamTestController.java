package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamTestController {
    
    @RequestMapping("/test1")
    public String testMethod1(@RequestParam("id") String userId){
        System.out.println("id=" + userId);
        return "forward:/index.jsp";
    }
    
    @RequestMapping("/test2")
    public String testMethod2(User user){
        System.out.println(user);
        return "forward:/index.jsp";
    }
    
}

class User {
    
    String id;
    String name;
    int age;
    
    //必须要有setter才能获取同名URL参数 !!!
    public void setId(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
