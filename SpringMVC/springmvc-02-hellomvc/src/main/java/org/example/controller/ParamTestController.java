package org.example.controller;

import org.example.controller.pojo.User;
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
