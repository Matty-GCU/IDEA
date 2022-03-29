package textbook.chapter04.aspectj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import textbook.chapter04.dynamic.proxy.jdk.Dao;

public class XMLAspectJTest {
    public static void main(String[] args) {
        ApplicationContext config = new ClassPathXmlApplicationContext("spring/applicationContextCh4.xml");
        Dao dao = (Dao) config.getBean("testDao2");
        dao.save();
    }
}
