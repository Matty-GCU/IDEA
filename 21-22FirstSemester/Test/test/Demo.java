package test;

public class Demo {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer();
        System.out.println(s.hashCode());
        System.out.println(s.append('c').hashCode());
        System.out.println(s.append('b').append('a').hashCode());
    }
}
