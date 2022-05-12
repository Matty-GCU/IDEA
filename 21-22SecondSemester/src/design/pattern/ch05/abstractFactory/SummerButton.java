package design.pattern.ch05.abstractfactory;

public class SummerButton implements Button {
    @Override
    public void display() {
        System.out.println("显示夏天皮肤的按钮");
    }
}
