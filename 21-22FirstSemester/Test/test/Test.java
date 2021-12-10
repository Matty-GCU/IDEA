package test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Matty's PC
 */
public class Test {
    public static void main(String[] args) {
        String s = "abc d e ff gghi";
        String[] sArr = s.split("d");
        for(int i = 0; i < sArr.length; i++) {
            System.out.println(sArr[i]);
        }
    }
}
