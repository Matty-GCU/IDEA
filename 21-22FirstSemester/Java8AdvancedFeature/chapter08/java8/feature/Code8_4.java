package chapter08.java8.feature;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Code8_4 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("str1", "str2", "str3", "str0");
        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        list1.forEach(System.out::println);
        System.out.println("-----------------------------------");
        List<String> list2 = Arrays.asList("str1", "str2", "str3", "str0");
        Collections.sort(list2, ((String o1, String o2) -> o2.compareTo(o1)));
        list2.forEach(System.out::println);
    }
}
