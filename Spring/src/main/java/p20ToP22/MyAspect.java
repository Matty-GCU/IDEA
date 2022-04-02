package p20ToP22;

/**
 * 简单纯粹的切面类
 */
public class MyAspect {
    public void before() {
        System.out.println("简单纯粹的前置通知");
    }
    public void after() {
        System.out.println("简单纯粹的后置通知");
    }
}
