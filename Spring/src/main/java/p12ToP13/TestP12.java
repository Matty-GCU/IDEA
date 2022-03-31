package p12ToP13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestP12 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("p12ToP13/beans.xml");
        Person i = applicationContext.getBean("I", Person.class);
        System.out.println(i);
    }
}
