package com.example.demo.textbook.service;

import com.example.demo.textbook.dao.TestDIDao;

public class TestDIServiceImpl implements TestDIService {

    private TestDIDao testDIDao;

    /**
     * 使用构造方法注入
     */
//    public TestDIServiceImpl(TestDIDao testDIDao) {
//        this.testDIDao = testDIDao;
//    }

    /**
     * 使用setter方法注入
     */
    public void setTestDIDao(TestDIDao testDIDao) {
        this.testDIDao = testDIDao;
    }

    @Override
    public void sayHello() {
        testDIDao.sayHello();
        System.out.println("成功实现依赖注入");
    }
}
