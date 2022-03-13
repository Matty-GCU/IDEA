package textbook.chapter04.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import textbook.chapter04.dynamic.proxy.jdk.Dao;

public class ProxyFactoryBeanTest {
    public static void main(String[] args) {
        ApplicationContext config = new ClassPathXmlApplicationContext("applicationContextCh4.xml");
        Dao dao = (Dao) config.getBean("testDaoProxy");
        System.out.println("==================");
        dao.save();
        System.out.println("==================");
        dao.modify();
        System.out.println("==================");
        dao.delete();
    }
}
