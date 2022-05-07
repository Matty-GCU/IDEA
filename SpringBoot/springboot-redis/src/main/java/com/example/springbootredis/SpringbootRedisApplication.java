package com.example.springbootredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootRedisApplication {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootRedisApplication.class, args);
        Object redisTemplate = context.getBean("redisTemplate");
        System.out.println(redisTemplate);
//        Object user = context.getBean("user2");
        Object user = context.getBean("user2Bean");
        System.out.println(user);
    }
    
}
