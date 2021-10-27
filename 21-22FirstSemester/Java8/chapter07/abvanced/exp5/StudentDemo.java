package chapter07.abvanced.exp5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class StudentDemo {
    public static void main(String[] args) {
        try {
            Class<Student> c = Student.class;
            Constructor<Student> constructor = c.getDeclaredConstructor();
            Student student = constructor.newInstance();
            Method method = c.getDeclaredMethod("setName", String.class);
            System.out.println("method:\n" + method);
            Field field = c.getDeclaredField("name");
            System.out.println("field:\n" + field);

            Scanner scanner = new Scanner(System.in);
            method.invoke(student, scanner.next());
            scanner.close();
            System.out.println(student.getName());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
