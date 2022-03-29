package textbook.chapter03.instantiation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test0301 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContextCh3.xml");

        //Bean的三种实例化方式
        System.out.println("默认singleton作用域：");
        BeanClass beanClass = (BeanClass) applicationContext.getBean("constructionInstance");
        System.out.println(beanClass + beanClass.message);
//        beanClass = (BeanClass) applicationContext.getBean("staticFactoryInstance");
//        System.out.println(beanClass + beanClass.message);
//        beanClass = (BeanClass) applicationContext.getBean("instanceFactoryInstance");
//        System.out.println(beanClass + beanClass.message);

        //Bean的两种作用域
        System.out.println("指定singleton作用域，重复获取三次同一个Bean，引用都相同，相当于只new了一次：");
        beanClass = (BeanClass) applicationContext.getBean("singletonScopeInstance");
        System.out.println(beanClass);
        beanClass = (BeanClass) applicationContext.getBean("singletonScopeInstance");
        System.out.println(beanClass);
        beanClass = (BeanClass) applicationContext.getBean("singletonScopeInstance");
        System.out.println(beanClass);
        System.out.println("指定prototype作用域，重复获取三次同一个Bean，引用都不同，相当于new了三次：");
        beanClass = (BeanClass) applicationContext.getBean("prototypeScopeInstance");
        System.out.println(beanClass);
        beanClass = (BeanClass) applicationContext.getBean("prototypeScopeInstance");
        System.out.println(beanClass);
        beanClass = (BeanClass) applicationContext.getBean("prototypeScopeInstance");
        System.out.println(beanClass);
        /**
         * 注意以上三个例子的类(class属性)虽然一模一样，
         * 但是配置文件里Bean的id属性不一样，
         * 所以Spring容器会将它们识别为三个不同的Bean，即使都是singleton作用域，最终得到的也是三个不同的实例引用。
         */
    }
}
