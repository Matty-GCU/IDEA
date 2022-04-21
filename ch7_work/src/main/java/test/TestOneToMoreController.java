package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.OneToMoreController;

public class TestOneToMoreController{
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		OneToMoreController oto = (OneToMoreController)appCon.getBean("oneToMoreController");
		oto.test();
	}
}
