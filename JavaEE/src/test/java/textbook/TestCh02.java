package textbook;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import textbook.chapter02.service.TestDIService;

public class TestCh02 {

    @Test
    void testDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextCh2.xml");
        TestDIService testDIService = (TestDIService) applicationContext.getBean("myTestDIService");
        testDIService.sayHello();
    }

}