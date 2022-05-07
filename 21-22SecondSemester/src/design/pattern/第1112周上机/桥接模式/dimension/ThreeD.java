package design.pattern.第1112周上机.桥接模式.dimension;

public class ThreeD extends Dimension {
    @Override
    public void displayMap() {
        platform.showMapOnPlatform();
        System.out.println("以三维形式展现");
    }
}
