package com.example.springbootredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {
    
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    
    @Test
    void set() {
        redisTemplate.boundValueOps("myKey1").set("myValue1");
    }
    
    @Test
    void get() {
        System.out.println(redisTemplate.boundValueOps("myKey1").get());
    }
}
