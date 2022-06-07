package design.pattern.上机实验.行为型设计模式.状态模式;

public abstract class WaterState {
    
    protected Water water;
    
    public WaterState(Water water) {
        this.water = water;
    }
    
    public abstract int heat(int ori, int change);
    
    public abstract int cool(int ori, int change);
    
    public Water getWater() {
        return water;
    }
    
    public void setWater(Water water) {
        this.water = water;
    }
    
}
