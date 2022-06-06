package design.pattern.上机实验.结构型设计模式.桥接模式.dimension;

public class ThreeD extends Dimension {
    @Override
    public void displayMap() {
        platform.showMapOnPlatform();
        System.out.println("以三维形式展现");
    }
}
