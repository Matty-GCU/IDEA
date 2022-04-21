package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dao.UserDao;
import po.Book;
import po.User;

@Controller("moreToMoreController")
public class MoreToMoreController {
	@Autowired
	private UserDao userDao;
	public void test() {
		List<User> u = userDao.selectallUserAndBook();
		for(User user : u) {
			System.out.println(user);
		}
	}
}
