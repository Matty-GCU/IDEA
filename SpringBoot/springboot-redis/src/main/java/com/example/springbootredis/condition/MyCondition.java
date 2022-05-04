package com.example.springbootredis.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
//import redis.clients.jedis.Jedis;

public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 需求：导入Jedis依赖后，允许创建Bean
        // 思路：判断redis.clients.jedis.Jedis.class是否存在
        boolean flag = true;
        try {
            Class.forName("redis.clients.jedis.Jedis");
        } catch (ClassNotFoundException e) {
            flag = false;
        }
        return flag;
    }
}
