package design.pattern.ch05.abstractfactory;

public class SummerTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示夏天皮肤的文本框");
    }
}
