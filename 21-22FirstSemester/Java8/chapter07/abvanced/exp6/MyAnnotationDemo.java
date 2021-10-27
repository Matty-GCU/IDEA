package chapter07.abvanced.exp6;

import java.lang.reflect.Method;

/**
 * @author Matty's PC
 */
public class MyAnnotationDemo {
    public static void main(String[] args) {
        Class<Customer> customerClass = Customer.class;
        Method m = null;
        try{
            m = customerClass.getMethod("buy");
            MyAnnotation a = m.getAnnotation(MyAnnotation.class);
            if(a != null) {
                System.out.println(a.price());
                System.out.println(a.num());
            }
        }
        catch(NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
