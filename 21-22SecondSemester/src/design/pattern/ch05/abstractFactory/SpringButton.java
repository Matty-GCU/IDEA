package design.pattern.ch05.abstractfactory;

public class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("显示春天皮肤的按钮");
    }
}
