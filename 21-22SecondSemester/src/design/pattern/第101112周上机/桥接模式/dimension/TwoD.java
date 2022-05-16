package design.pattern.第101112周上机.桥接模式.dimension;

public class TwoD extends Dimension {
    @Override
    public void displayMap() {
        platform.showMapOnPlatform();
        System.out.println("以二维形式展现");
    }
}
