package design.pattern.上机实验.结构型设计模式.桥接模式.platform;

import design.pattern.上机实验.结构型设计模式.桥接模式.company.Map;

public abstract class Platform {
    protected Map map;
    
    public void setMap(Map map) {
        this.map = map;
    }
    
    public abstract void showMapOnPlatform();
}
