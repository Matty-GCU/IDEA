package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Matty's PC
 */
public class Test {
    public static void main(String[] args) {
        System.out.println((int)(26 / 0.75F + 1.0F));
        Map<Character, String> hashMap = new HashMap<>((int)(26 / 0.75F + 1.0F));
    }
}
