package design.pattern.第1112周上机.桥接模式;

import design.pattern.第1112周上机.桥接模式.company.GaodeMap;
import design.pattern.第1112周上机.桥接模式.company.Map;
import design.pattern.第1112周上机.桥接模式.dimension.Dimension;
import design.pattern.第1112周上机.桥接模式.dimension.ThreeD;
import design.pattern.第1112周上机.桥接模式.platform.Platform;
import design.pattern.第1112周上机.桥接模式.platform.WebPlatform;

public class Client {
    public static void main(String[] args) {
        // 以下所有维度选择、注入的代码实际上都可以通过读取XML文件+反射的方式完成，
        // 改变任意一个维度的实现类/继承类时不需要改变源码，符合开闭原则。
        Platform platform = new WebPlatform();
        Map map = new GaodeMap();
        platform.setMap(map);
        
//        platform.showMapOnPlatform();
        
        // 增加需求后
        Dimension dimension = new ThreeD();
        dimension.setPlatform(platform);
        
        dimension.displayMap();
    }
}
