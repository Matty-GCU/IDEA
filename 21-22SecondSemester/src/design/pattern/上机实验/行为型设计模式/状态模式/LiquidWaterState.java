package design.pattern.上机实验.行为型设计模式.状态模式;

public class LiquidWaterState extends WaterState {
    
    public LiquidWaterState(Water water) {
        super(water);
    }
    
    @Override
    public int heat(int ori, int change) {
        int result = ori + change;
        if (result > 100) {
            water.setWaterState(new GasWaterState(water));
        }
        return result;
    }
    
    @Override
    public int cool(int ori, int change) {
        int result = ori - change;
        if (result < 0) {
            water.setWaterState(new SolidWaterState(water));
        }
        return result;
    }
    
    @Override
    public String toString() {
        return "液态";
    }
}
