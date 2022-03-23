package design.pattern.ch12.decorator;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        // 透明装饰模式
        Component component = new ConcreteComponentA();
        Component decorator = new ConcreteDecoratorB(component);
        decorator.operation();
    }
}
