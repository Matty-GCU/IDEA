package design.pattern.ch12.decorator;

public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }

    public void addBehavior() {
        System.out.println("新增装饰类B的业务方法");
    }

}
