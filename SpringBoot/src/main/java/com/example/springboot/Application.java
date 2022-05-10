package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println("===============");
        Jedis jedis = (Jedis) context.getBean("jedis");
        System.out.println(jedis);
        System.out.println(jedis.set("name", "小吴"));
        System.out.println(jedis.get("name"));
    }
    
}
