package com.example.springbootenable;

import com.example.springbootenableothers.config.EnableUser;
import com.example.springbootenableothers.config.MyConfig;
import com.example.springbootenableothers.config.MyImportBeanDefinitionRegistrar;
import com.example.springbootenableothers.config.MyImportSelector;
import com.example.springbootenableothers.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Map;

@SpringBootApplication
// 引入其他项目的依赖后，如何在本项目中获取其他项目声明的Bean？
//@ComponentScan("com.example.springbootenableothers.pojo")     //需要该类使用@Component注解才能扫描到
//@Import(User.class)   //这样导入的话，User可以不加@Repository注解
//@Import(MyConfig.class)     //这样导入的话，MyConfig可以不加@Configuration注解
//@EnableUser
//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinitionRegistrar.class)
public class SpringbootEnableApplication {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootEnableApplication.class, args);
        
        //若发现找不到Bean，可以使用这种方式查看Bean名（此时Bean名不是"user"，而很可能是User类的全限定名）
        //a Map with the matching beans, containing the bean names as keys and the corresponding bean instances as values
        Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);
        System.out.println(beansOfType);
        User user1 = applicationContext.getBean(User.class);
        System.out.println(user1);
        
        Object user = applicationContext.getBean("user");
        System.out.println(user);
        
    }
    
}
