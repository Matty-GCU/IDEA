package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {
    
    @RequestMapping("/testController2")
    public String test() {
        System.out.println("执行处理器方法");
        return "OK";
    }
}
