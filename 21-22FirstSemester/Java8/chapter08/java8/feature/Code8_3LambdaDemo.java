package chapter08.java8.feature;

import java.util.Arrays;
import java.util.List;

/**
 * @author Matty's PC
 */
public class Code8_3LambdaDemo {
    public static void main(String[] args) {
        String[] names = {"吴", "黄", "林"};
        List<String> list = Arrays.asList(names);
        System.out.println("foreach输出：");
        for(String name: names) {
            System.out.println(name);
        }
        System.out.println("Java 8 Lambda表达式输出：");
        list.forEach(name -> System.out.println(name));
        System.out.println("Java8 双冒号操作符");
        list.forEach(System.out::println);
//        new Object().hashCode()
    }
}
