package design.pattern.上机实验.行为型设计模式.状态模式;

/**
 * 充当环境类
 */
public class Water {
    
    WaterState waterState;
    int x;
    
    public Water() {
        x = 0;
    }
    
    public WaterState getWaterState() {
        return waterState;
    }
    
    public void setWaterState(WaterState waterState) {
        this.waterState = waterState;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
}
