package design.pattern.第1112周上机.桥接模式.platform;

import design.pattern.第1112周上机.桥接模式.company.Map;

public abstract class Platform {
    protected Map map;
    
    public void setMap(Map map) {
        this.map = map;
    }
    
    public abstract void showMapOnPlatform();
}
