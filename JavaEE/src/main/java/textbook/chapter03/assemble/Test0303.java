package textbook.chapter03.assemble;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import textbook.chapter03.assemble.annotaion.SimpleUser;
import textbook.chapter03.assemble.annotaion2.TestController;
import textbook.chapter03.assemble.annotation3.Parrot;
import textbook.chapter03.assemble.annotation3.TestConfig;
import textbook.chapter03.assemble.xml.ComplexUser;

public class Test0303 {
    public static void main(String[] args) {
        //基于XML配置文件的装配方式
        ClassPathXmlApplicationContext xmlConfig = new ClassPathXmlApplicationContext("spring/applicationContextCh3.xml");
        System.out.println("\n方法一：使用构造方法注入依赖");
        ComplexUser complexUser1 = (ComplexUser) xmlConfig.getBean("complexBeanTest1");
        System.out.println(complexUser1);
        System.out.println(complexUser1.hashCode());

        System.out.println("\n方法二：使用属性的setter注入依赖");
        ComplexUser complexUser2 = (ComplexUser) xmlConfig.getBean("complexBeanTest2");
        System.out.println(complexUser2);
        System.out.println(complexUser2.hashCode());

        //基于注解的装配（推荐使用）
        System.out.println("\n最简单的注解：");
        SimpleUser simpleUser = (SimpleUser) xmlConfig.getBean("annotationUser");
        System.out.println(simpleUser);

        System.out.println("\n其他常用注解：");
        TestController controller = (TestController) xmlConfig.getBean("testController");
        controller.saveData();

        //老师在学习通章节3.6中补充的内容
        System.out.println("\n连上下文配置都用注解：");
        var annotationConfig = new AnnotationConfigApplicationContext(TestConfig.class);
        Parrot parrot = annotationConfig.getBean(Parrot.class);
        System.out.println(parrot);
        parrot = (Parrot) annotationConfig.getBean("a strange parrot");
        System.out.println(parrot);
        String s = annotationConfig.getBean(String.class);
        System.out.println(s);
    }
}
