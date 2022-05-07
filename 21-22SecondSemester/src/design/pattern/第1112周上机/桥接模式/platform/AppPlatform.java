package design.pattern.第1112周上机.桥接模式.platform;

public class AppPlatform extends Platform {
    @Override
    public void showMapOnPlatform() {
        map.getMapData();
        System.out.println("在APP显示地图");
    }
}
