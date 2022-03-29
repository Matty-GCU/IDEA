package p8ToP10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestP8ToP10 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("p8ToP10/config.xml");
        //小技巧：可以传一个requiredType参数，这样就不用强转了
        Student aStudent = applicationContext.getBean("aStudent", Student.class);
        System.out.println(aStudent);
    }
}
