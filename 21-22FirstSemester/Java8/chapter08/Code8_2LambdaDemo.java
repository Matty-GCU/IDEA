package chapter08;

import java.util.Arrays;
import java.util.List;

/**
 * @author Matty's PC
 */
public class Code8_2LambdaDemo {
    public static void main(String[] args) {
        String[] names = {"吴", "黄", "林"};
        List<String> arrName = Arrays.asList(names);
        System.out.println("foreach输出：");
        for(String name: names) {
            System.out.println(name);
        }
        System.out.println("Java 8 Lambda表达式输出：");
        arrName.forEach((name) -> System.out.println(name));
        System.out.println("Java8 双冒号操作符");
        arrName.forEach(System.out::println);
//        new Object().hashCode()
    }
}
