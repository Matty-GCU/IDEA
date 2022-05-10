package com.example.justfortest.config;

import com.example.justfortest.pojo.Student;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConfigurationPropertiesScan
@EnableConfigurationProperties(StudentProperties.class)
public class StudentConfig {
    
    @Bean
    public Student student(StudentProperties studentProperties) {
        return new Student(studentProperties.getAge());
    }
}
