package com.example.springbootactuator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    //在/actuator/mappings里看看有没有这条映射
    @RequestMapping("/user")
    public String test() {
        return "11";
    }
}
