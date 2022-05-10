package design.pattern.ch24.strategy.example1;

public class Ch24Test01 {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategy1());
        context.algorithm();
    }
}
