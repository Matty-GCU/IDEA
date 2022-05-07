package com.example.springbootredis.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
//import redis.clients.jedis.Jedis;

public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 需求1：导入Jedis依赖后，才允许创建Bean
        // 思路：判断redis.clients.jedis.Jedis.class是否存在
//        boolean flag = true;
//        try {
//            Class.forName("redis.clients.jedis.Jedis");
//        } catch (ClassNotFoundException e) {
//            flag = false;
//        }
//        return flag;
        
        // 需求2：导入指定依赖后，才允许创建Bean
        System.out.println(ConditionOnMethod.class.getName());
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionOnMethod.class.getName());
        assert annotationAttributes != null;
        String[] classNames = (String[]) annotationAttributes.get("classNames");
        boolean flag = true;
        try {
            for (String className : classNames) {
                Class.forName(className);
            }
        } catch (ClassNotFoundException e) {
            flag = false;
        }
        return flag;
    }
}
