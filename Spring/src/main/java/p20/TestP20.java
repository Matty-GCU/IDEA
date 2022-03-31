package p20;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestP20 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("p20/applicationContext.xml");
        ServiceP20 service = applicationContext.getBean("myService", ServiceP20.class);
        service.delete();
        service.insert();
        service.select();
        service.update();
    }
}
