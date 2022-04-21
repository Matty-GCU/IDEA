package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;


import dao.UserDao;
import pojo.SelectUserById;

@Controller("oneToOneController")
public class OneToOneController {
	@Autowired
	private UserDao userDao;
	public void test() {
		SelectUserById subi = userDao.selectUserById(1);
		System.out.println(subi);
	}

}
