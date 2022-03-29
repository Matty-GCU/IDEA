package textbook.chapter05.declaration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCh0503 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContextCh5.3.xml");
        TestControllerCh0503 controller = (TestControllerCh0503) context.getBean("testControllerCh0503");
        controller.test();
    }
}
