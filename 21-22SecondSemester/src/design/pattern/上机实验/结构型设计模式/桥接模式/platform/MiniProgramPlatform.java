package design.pattern.上机实验.结构型设计模式.桥接模式.platform;

public class MiniProgramPlatform extends Platform {
    @Override
    public void showMapOnPlatform() {
        map.getMapData();
        System.out.println("在小程序显示地图");
    }
}
