package textbook.chapter01.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test01 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContextCh1.xml");
        TestDao testDao = (TestDao) applicationContext.getBean("test");
        testDao.sayHello();

        applicationContext = new FileSystemXmlApplicationContext("C:\\Users\\Matty's PC\\IdeaProjects\\JavaEE\\src\\main\\resources\\applicationContextCh1.xml");
        testDao = (TestDao) applicationContext.getBean("test");
        testDao.sayHello();
    }

}