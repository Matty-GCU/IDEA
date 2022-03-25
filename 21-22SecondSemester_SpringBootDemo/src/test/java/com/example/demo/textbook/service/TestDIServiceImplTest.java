package com.example.demo.textbook.service;

import com.example.demo.textbook.dao.TestDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

class TestDIServiceImplTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestDao testDao = (TestDao) applicationContext.getBean("test");
        testDao.sayHello();

        applicationContext = new FileSystemXmlApplicationContext("C:\\Users\\Matty's PC\\IdeaProjects\\demo\\target\\classes\\applicationContext.xml");
        testDao = (TestDao) applicationContext.getBean("test");
        testDao.sayHello();
    }

    @Test
    void testDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestDIService testDIService = (TestDIService) applicationContext.getBean("myTestDIService");
        testDIService.sayHello();
    }

}