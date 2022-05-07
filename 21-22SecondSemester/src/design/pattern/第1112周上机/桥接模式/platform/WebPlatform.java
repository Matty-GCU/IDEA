package design.pattern.第1112周上机.桥接模式.platform;

public class WebPlatform extends Platform {
    @Override
    public void showMapOnPlatform() {
        map.getMapData();
        System.out.println("在浏览器显示地图");
    }
}
