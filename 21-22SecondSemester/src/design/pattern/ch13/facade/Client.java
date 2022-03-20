package design.pattern.ch13.facade;

public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method01();
        facade.method02();
    }
}
