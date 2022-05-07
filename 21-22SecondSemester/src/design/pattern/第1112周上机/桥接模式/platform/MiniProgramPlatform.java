package design.pattern.第1112周上机.桥接模式.platform;

public class MiniProgramPlatform extends Platform {
    @Override
    public void showMapOnPlatform() {
        map.getMapData();
        System.out.println("在小程序显示地图");
    }
}
