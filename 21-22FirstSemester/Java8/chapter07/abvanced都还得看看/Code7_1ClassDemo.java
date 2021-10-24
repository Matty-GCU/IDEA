package chapter07.abvanced都还得看看;

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
