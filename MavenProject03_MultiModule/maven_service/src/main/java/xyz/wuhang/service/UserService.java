package xyz.wuhang.service;

import xyz.wuhang.dao.UserDao;

public class UserService {
    public static void test() {
        System.out.println("UserService test...");
        //调用maven_dao模块的方法
        UserDao.test();
    }
}