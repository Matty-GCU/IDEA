package p15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import p15.config.MyConfig;
import p15.pojo.User;

public class AnnotationTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        User user = applicationContext.getBean("getUser", User.class);
        System.out.println(user);
    }
}
