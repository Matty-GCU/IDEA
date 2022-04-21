package controller;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import po.User;

import java.util.List;

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
