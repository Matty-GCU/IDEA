package controller;

import dao.BookShelfDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pojo.SelectBookShelfById;

import java.util.List;

@Controller("oneToMoreController")
public class OneToMoreController {
	@Autowired
	private BookShelfDao bs;
	public void test() {
		List<SelectBookShelfById> sb = bs.selectBookShelfById(1);
		System.out.println(sb);
	}
}
