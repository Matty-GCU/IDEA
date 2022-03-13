package design.pattern.ch05.abstractFactory;

public class SpringTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示春天皮肤的文本框");
    }
}
