package com.example.springbootenableothers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootEnableOthersApplication {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootEnableOthersApplication.class, args);
        Object user = applicationContext.getBean("user");
        System.out.println(user);
    }
    
}
