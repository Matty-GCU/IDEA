package p15.pojo;

import org.springframework.beans.factory.annotation.Value;
public class User {
    
    @Value("一个名字")
    String name;
    
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
