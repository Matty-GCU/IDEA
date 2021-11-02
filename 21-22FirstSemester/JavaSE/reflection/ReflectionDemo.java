package reflection;

import chapter07.abvanced.exp6.MyAnnotation;

import java.lang.reflect.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author Matty's PC
 */
public class ReflectionDemo {

    @MyAnnotation(num = 100)
    public HashSet<Double> testMethod(Map<String, Integer> map, List<String> list, int i) {
        System.out.println("testMethod");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        for(int i = 0; i < 10; ) {
            System.out.println(5);
        }
        Method method = ReflectionDemo.class.getDeclaredMethod("testMethod", Map.class, List.class, int.class);
        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.num());
    }
}