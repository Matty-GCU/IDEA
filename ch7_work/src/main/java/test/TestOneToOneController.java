package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.OneToOneController;

public class TestOneToOneController {
	
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		OneToOneController oto = (OneToOneController)appCon.getBean("oneToOneController");
		oto.test();
	}
}
