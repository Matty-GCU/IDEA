package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.MoreToMoreController;

public class testMoreToMoreController {
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		MoreToMoreController mtm = (MoreToMoreController)appCon.getBean("moreToMoreController");
		mtm.test();
	}
}
