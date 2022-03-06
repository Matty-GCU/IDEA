package textbook.chapter03.instantiation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextCh3.xml");
        BeanClass beanClass = (BeanClass) applicationContext.getBean("constructionInstance");
        System.out.println(beanClass + beanClass.message);

        beanClass = (BeanClass) applicationContext.getBean("staticFactoryInstance");
        System.out.println(beanClass + beanClass.message);

        beanClass = (BeanClass) applicationContext.getBean("instanceFactoryInstance");
        System.out.println(beanClass + beanClass.message);
    }
}
