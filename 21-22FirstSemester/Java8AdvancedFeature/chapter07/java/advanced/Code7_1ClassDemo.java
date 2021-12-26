package chapter07.java.advanced;

public class Code7_1ClassDemo {
    public static void main(String[] args) {
        try {
            Class<?> strClass = Class.forName("java.lang.String");
            System.out.println(strClass);
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
