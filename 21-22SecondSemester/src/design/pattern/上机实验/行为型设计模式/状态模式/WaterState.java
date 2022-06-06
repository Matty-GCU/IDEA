package design.pattern.上机实验.行为型设计模式.状态模式;

public abstract class WaterState {
    
    Water water;
    
    public WaterState(Water water) {
        this.water = water;
    }
    
    public abstract void heat();
    
    public abstract void cool();
    
    public Water getWater() {
        return water;
    }
    
    public void setWater(Water water) {
        this.water = water;
    }
}
