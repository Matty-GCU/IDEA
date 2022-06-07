package design.pattern.上机实验.行为型设计模式.状态模式;

public class GasWaterState extends WaterState {
    
    public GasWaterState(Water water) {
        super(water);
    }
    
    @Override
    public int heat(int ori, int change) {
        int result = ori + change;
        return result;
    }
    
    @Override
    public int cool(int ori, int change) {
        int result = ori - change;
        if (result > 0 && result < 100) {
            water.setWaterState(new LiquidWaterState(water));
        }
        else if (result < 0) {
            water.setWaterState(new SolidWaterState(water));
        }
        return result;
    }
    
    @Override
    public String toString() {
        return "气态";
    }
}
