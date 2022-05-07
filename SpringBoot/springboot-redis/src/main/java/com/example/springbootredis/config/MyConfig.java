package com.example.springbootredis.config;

import com.example.springbootredis.condition.ConditionOnMethod;
import com.example.springbootredis.entity.User2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
//    @Conditional(MyCondition.class)
    @ConditionOnMethod(classNames = "redis.clients.jedis.Jedis")
    public User2 user2() {
        return new User2();
    }
    
    @Bean
    @ConditionalOnProperty(name = "abc", havingValue = "111")
    public User2 user2Bean() {
        return new User2();
    }
}
