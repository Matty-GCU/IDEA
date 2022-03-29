package textbook.chapter02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import textbook.chapter02.service.TestDIService;

public class Test02 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContextCh2.xml");
        TestDIService testDIService = (TestDIService) applicationContext.getBean("myTestDIService");
        testDIService.sayHello();
    }

}