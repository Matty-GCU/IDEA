package test;

public class Test {

    public void eat(int a) {
        System.out.println("吃东西。" + "a=" + a);
    }

    public static void main(String[] args) {
        //Lambda表达式写法：
        Dog dog1 = (a) -> System.out.println("吃东西。" + "a=" + a);
        Cat cat1 = (a) -> System.out.println("吃东西。" + "a=" + a);
        dog1.doSomething(5);
        cat1.doSomething(5);
        //方法引用写法：
        Test test = new Test();
        Dog dog2 = test::eat;
        Cat cat2 = test::eat;
        dog2.doSomething(10);
        cat2.doSomething(10);
    }
}

@FunctionalInterface
interface Dog {
    void doSomething(int a);
}

@FunctionalInterface
interface Cat {
    void doSomething(int a);
}