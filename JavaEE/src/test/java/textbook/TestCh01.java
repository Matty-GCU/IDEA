package textbook;

import textbook.chapter01.dao.TestDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestCh01 {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextCh1.xml");
        TestDao testDao = (TestDao) applicationContext.getBean("test");
        testDao.sayHello();

        applicationContext = new FileSystemXmlApplicationContext("C:\\Users\\Matty's PC\\IdeaProjects\\JavaEE\\src\\main\\resources\\applicationContextCh1.xml");
        testDao = (TestDao) applicationContext.getBean("test");
        testDao.sayHello();
    }

}