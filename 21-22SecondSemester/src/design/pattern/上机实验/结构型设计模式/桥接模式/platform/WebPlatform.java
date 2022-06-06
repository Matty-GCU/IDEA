package design.pattern.上机实验.结构型设计模式.桥接模式.platform;

public class WebPlatform extends Platform {
    @Override
    public void showMapOnPlatform() {
        map.getMapData();
        System.out.println("在浏览器显示地图");
    }
}
