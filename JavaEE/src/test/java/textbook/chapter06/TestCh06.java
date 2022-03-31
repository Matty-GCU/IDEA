package textbook.chapter06;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import textbook.chapter06.controller.DriverController;

public class TestCh06 {
    @Test
    void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mybatis/ch06/applicationContextCh06.xml");
        DriverController driverController = applicationContext.getBean("driverController", DriverController.class);
        driverController.test();
    }
}
