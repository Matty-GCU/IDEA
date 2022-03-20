package design.pattern.ch13.facade;

public class Facade {
    
    private SubSystemA subSystemA = new SubSystemA();
    private SubSystemB subSystemB = new SubSystemB();
    private SubSystemC subSystemC = new SubSystemC();
    
    public void method01() {
        System.out.println("完成一项比较复杂的功能01");
        subSystemA.methodA();
        subSystemB.methodB();
        subSystemC.methodC();
    }
    public void method02() {
        System.out.println("完成一项比较复杂的功能02");
        subSystemA.methodA();
        subSystemC.methodC();
    }
}
