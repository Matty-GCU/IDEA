package textbook.chapter05.declaration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCh0503 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextCh5.xml");
        TestServiceCh05 testServiceCh05 = (TestServiceCh05Impl) context.getBean("testServiceCh05Impl");
        testServiceCh05.test();
    }
}
