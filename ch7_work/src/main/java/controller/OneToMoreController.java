package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dao.BookShelfDao;
import pojo.SelectBookShelfById;

@Controller("oneToMoreController")
public class OneToMoreController {
	@Autowired
	private BookShelfDao bs;
	public void test() {
		List<SelectBookShelfById> sb = bs.selectBookShelfById(1);
		System.out.println(sb);
	}
}
