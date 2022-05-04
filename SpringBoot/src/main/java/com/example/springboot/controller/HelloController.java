package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @Value("${myName}")
    String name;
    
    @Value("${location.city}")
    String city;
    
    @Value("${location.school}")
    String school;
    
    @Value("${myArray[0]}")
    int one;
    
    @Value("${myArray[1]}")
    int two;
    
    @Value("${myArray[2]}")
    String abc;
    
    @Autowired
    Environment environment;
    
    @Autowired
    MyLocation myLocation;
    
    @RequestMapping("/")
    public String hello() {
        System.out.println(name);
        System.out.println(city);
        System.out.println(school);
        System.out.println(one);
        System.out.println(two);
        System.out.println(abc);
        System.out.println("============");
        System.out.println(environment.getProperty("myName"));
        System.out.println(environment.getProperty("myArray[1]"));
        System.out.println("============");
        System.out.println(myLocation);
        return "Hello Spring Boot!";
    }
}
