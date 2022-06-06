package design.pattern.上机实验.结构型设计模式.桥接模式.dimension;

import design.pattern.上机实验.结构型设计模式.桥接模式.platform.Platform;

public abstract class Dimension {
    protected Platform platform;
    
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
    
    public abstract void displayMap();
}
