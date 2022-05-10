package com.example.justfortest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JustfortestApplication {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JustfortestApplication.class, args);
        Object student = context.getBean("student");
        System.out.println(student);
    }
    
}
