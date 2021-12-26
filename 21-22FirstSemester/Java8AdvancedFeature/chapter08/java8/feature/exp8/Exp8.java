package chapter08.java8.feature.exp8;

import java.util.*;

public class Exp8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> arrayList = new ArrayList<>();
        while(true) {
            Student stu = new Student();
            String str = null;
            for(int i = 0; i < 3; i++) {
                if(i == 0) {
                    System.out.println("请输入学生姓名：");
                    str = sc.next();
                    if("-1".equals(str)) {
                        break;
                    }
                    stu.setName(str);
                }
                else if(i == 1) {
                    System.out.println("请输入学生学号：");
                    str = sc.next();
                    if("-1".equals(str)) {
                        break;
                    }
                    stu.setId(str);
                }
                else {
                    System.out.println("请输入学生所在学院：");
                    str = sc.next();
                    if("-1".equals(str)) {
                        break;
                    }
                    stu.setDepartment(str);
                }
            }
            if("-1".equals(str)) {
                break;
            }
            arrayList.add(stu);
        }
        Collections.sort(arrayList, ((Student o1, Student o2) -> o2.getId().compareTo(o1.getId())));
        arrayList.forEach(System.out::println);
    }
}
