package textbook.chapter03.assemble;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import textbook.chapter03.assemble.annotaion.AnnotationUser;
import textbook.chapter03.assemble.xml.ComplexUser;

public class Test0303 {
    public static void main(String[] args) {
        //基于XML配置文件的装配方式
        ClassPathXmlApplicationContext config = new ClassPathXmlApplicationContext("applicationContextCh3.xml");
        System.out.println("方法一：使用构造方法注入依赖");
        ComplexUser complexUser1 = (ComplexUser) config.getBean("complexBeanTest1");
        System.out.println(complexUser1);
        System.out.println(complexUser1.hashCode());

        System.out.println("方法二：使用属性的setter注入依赖");
        ComplexUser complexUser2 = (ComplexUser) config.getBean("complexBeanTest2");
        System.out.println(complexUser2);
        System.out.println(complexUser2.hashCode());

        //基于注解的装配（推荐使用）
        AnnotationUser annotationUser = (AnnotationUser) config.getBean("annotationUser");
        System.out.println(annotationUser);
    }
}
