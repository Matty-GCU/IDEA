package com.example.springbootenableothers.config;

import com.example.springbootenableothers.pojo.Admin;
import com.example.springbootenableothers.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MyConfig {
    @Bean
    public User user() {
        return new User();
    }
    
    @Bean
    public Admin admin() {
        return new Admin();
    }
}
