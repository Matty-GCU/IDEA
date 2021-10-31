package annotation;

import java.lang.annotation.Inherited;

public class AnnotationDemo {

    @java.lang.Override
    public String toString() {
        return null;
    }

    @MyAnnotation(myAge = 19)
    public void method01() {
    }

    public static void main(String[] args) {
        System.out.println("程序正常运行");
    }

}
