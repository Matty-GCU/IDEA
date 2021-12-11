package chapter03.string;

public class StringBufferUtilTest {
    public static void main(String[] args) {
        StringBufferUtil s1 = new StringBufferUtil("aaaa");
        System.out.println(s1);
        String pattern = "a", s = "ab";
        System.out.println(s1.replaceAll(pattern, s));

        StringBufferUtil s2 = new StringBufferUtil("ababcdefdefabcabcgh");
        System.out.println(s2);
        String pattern2 = "abc";
        System.out.println(s2.removeAll(pattern2));
    }
}
