package com.example.springbootredis.condition;

import org.springframework.context.annotation.Conditional;

@Conditional(MyCondition.class)
public @interface ConditionOnMethod {
    String[] myValue();
}
