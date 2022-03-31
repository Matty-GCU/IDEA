package p15.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import p15.pojo.User;

@Configuration
public class MyConfig {

    @Bean
    public User getUser() {
        return new User();
    }
}
