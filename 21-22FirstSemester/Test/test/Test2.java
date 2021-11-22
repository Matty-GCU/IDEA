package test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Matty's PC
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("str1", "str2", "str3", "str0");
        list.sort(String::compareTo);
        list.forEach(System.out::println);
        ArrayList<Integer> i = new ArrayList<>();
        Integer[] a = new Integer[5];
        i.toArray(a);
        HashMap<Integer, Integer> s = new HashMap<>();
    }
}
