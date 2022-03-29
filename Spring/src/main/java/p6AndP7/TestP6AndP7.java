package p6AndP7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestP6AndP7 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("p6AndP7/configP6-7.xml");
        //bean标签的id属性
        User user0 = (User) applicationContext.getBean("myUser");
        user0.showName();
        System.out.println(user0);
        //alias标签的alias属性
        User user1 = (User) applicationContext.getBean("userAlias1");
        user1.showName();
        System.out.println(user1);
        User user2 = (User) applicationContext.getBean("userAlias2");
        user2.showName();
        System.out.println(user2);
        //bean标签的name属性
        User user3 = (User) applicationContext.getBean("alias3");
        user3.showName();
        System.out.println(user3);
        User user4 = (User) applicationContext.getBean("alias4");
        user4.showName();
        System.out.println(user4);
        User user5 = (User) applicationContext.getBean("alias5");
        user5.showName();
        System.out.println(user5);
        User user6 = (User) applicationContext.getBean("alias6");
        user6.showName();
        System.out.println(user6);
    }
}
