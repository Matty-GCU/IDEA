package p20ToP22;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestP20 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("p20ToP22/applicationContext.xml");
        ServiceP20 service = applicationContext.getBean("myService", ServiceP20.class);
        service.delete();
//        service.insert();
//        service.select();
//        service.update();
    }
}
