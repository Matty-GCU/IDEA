package p6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestP6 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("configP6.xml");
        System.out.println("---在加载配置文件时，IoC容器就已经帮我们new好了Bean（实例化Spring管理的对象）---");
        User user = (User) applicationContext.getBean("myUser");
        user.showName();
    }
}
