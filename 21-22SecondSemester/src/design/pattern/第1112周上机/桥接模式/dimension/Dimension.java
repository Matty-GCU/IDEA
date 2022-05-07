package design.pattern.第1112周上机.桥接模式.dimension;

import design.pattern.第1112周上机.桥接模式.platform.Platform;

public abstract class Dimension {
    protected Platform platform;
    
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
    
    public abstract void displayMap();
}
