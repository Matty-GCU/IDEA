package design.pattern.ch12.decorator;

public class ConcretorDecoratorA extends Decorator {

    public ConcretorDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }

    public void addBehavior() {
        System.out.println("新增装饰类A的业务方法");
    }
}
