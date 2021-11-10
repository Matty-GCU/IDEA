package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Matty's PC
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("str1", "str2", "str3", "str0");
        list.sort(String::compareTo);
        list.forEach(System.out::println);
    }
}