package design.pattern.ch24.strategy.example1;

public class ConcreteStrategy1 implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("算法实现1");
    }
}
