package test;

public class Test {
    public static void main(String[] args) {
        //写成这样是不是和匿名类实现接口方法很像？
        I01 i01 = () -> {
            System.out.println("无返回值、无参数");
        };
        I02 i02 = (int a) -> {
            System.out.println("无返回值，单个参数。a=" + a);
        };
        I03 i03 = (int a, int b) -> {
            System.out.println("无返回值，多个参数。a=" + a + ",b=" + b);
        };
        I04 i04 = () -> {
            System.out.println("有返回值、无参数");
            return 4;
        };
        I05 i05 = (int a) -> {
            System.out.println("有返回值，单个参数。a=" + a);
            return 5;
        };
        I06 i06 = (int a, int b) -> {
            System.out.println("有返回值，多个参数。a=" + a + ",b=" + b);
            return 6;
        };
        i01.method();
        i02.method(5);
        i03.method(5,10);
        System.out.println(i04.method());
        System.out.println(i05.method(5));
        System.out.println(i06.method(5, 10));
    }
}

interface I01 {
    void method();
//    void method2();
}

interface I02 {
    void method(int a);
}

interface I03 {
    void method(int a, int b);
}

interface I04 {
    int method();
}

interface I05 {
    int method(int a);
}

interface I06 {
    int method(int a, int b);
}
