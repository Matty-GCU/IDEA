package com.example.myautoconfigure.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
@ConfigurationPropertiesScan
public class MyRedisAutoConfiguration {
    
    @Bean
    @ConditionalOnMissingBean   //当Bean Factory里没有同名Bean（用户没有自己声明）时，该Bean才会被注册
//    @ConditionalOnMissingBean(name = "jedis")
    public Jedis jedis(MyRedisProperties redisProperties) {
        System.out.println("hhh");
        return new Jedis(redisProperties.getHost(), redisProperties.getPort());
    }
}
