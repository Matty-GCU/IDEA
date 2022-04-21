package controller;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
