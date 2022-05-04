package com.example.springbootredis.entity;

import org.springframework.stereotype.Repository;

/**
 * 仅为了演示Condition
 */
//这样标注则一定能通过getBean获取，但我们想达到的效果是能根据不同情况，决定spring容器能不能获取到Bean
//@Repository
public class User2 {
    int id;
    String username;
    String password;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "User2{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
