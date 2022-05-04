package com.example.springbootredis.config;

import com.example.springbootredis.condition.ConditionOnMethod;
import com.example.springbootredis.condition.MyCondition;
import com.example.springbootredis.entity.User2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
//    @Conditional(MyCondition.class)
    @ConditionOnMethod(myValue = "mredis.clients.jedis.Jedis")
    public User2 get2() {
        return new User2();
    }
}
