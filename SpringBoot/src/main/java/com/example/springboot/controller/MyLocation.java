package com.example.springboot.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "location")
public class MyLocation {
    private String city;
    private String school;
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getSchool() {
        return school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
    
    @Override
    public String toString() {
        return "MyLocation{" +
                "city='" + city + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
