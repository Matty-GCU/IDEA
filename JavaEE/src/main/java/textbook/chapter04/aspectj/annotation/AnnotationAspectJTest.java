package textbook.chapter04.aspectj.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import textbook.chapter04.dynamic.proxy.jdk.Dao;

public class AnnotationAspectJTest {
    public static void main(String[] args) {
        ApplicationContext config = new ClassPathXmlApplicationContext("applicationContextCh4.xml");
        Dao dao = (Dao) config.getBean("testDao3");
        dao.save();
    }
}
