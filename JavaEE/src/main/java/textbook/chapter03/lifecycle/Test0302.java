package textbook.chapter03.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test0302 {
    public static void main(String[] args) {
        System.out.println("创建一个Spring容器，开始加载配置文件：");
        // Create a new ClassPathXmlApplicationContext,
        // loading the definitions from the given XML file and automatically refreshing the context.
        ClassPathXmlApplicationContext config = new ClassPathXmlApplicationContext("applicationContextCh3.xml");
        System.out.println("配置文件加载完成。");

        System.out.println("获得一个Bean对象：");
        // nothing happened
        BeanLife beanLife = (BeanLife) config.getBean("beanLifeTest");
        System.out.println("获取Bean对象完成");

        System.out.println("关闭Spring容器：");
        //Close this application context, destroying all beans in its bean factory.
        config.close();
        System.out.println("Spring容器已关闭。");
    }
}
