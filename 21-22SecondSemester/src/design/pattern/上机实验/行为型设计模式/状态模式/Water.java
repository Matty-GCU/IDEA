package design.pattern.上机实验.行为型设计模式.状态模式;

/**
 * 充当环境类
 */
public class Water {
    
    private WaterState waterState;
    private int x;
    
    public Water() {
        x = 20;
        waterState = new LiquidWaterState(this);
    }
    
    public void heat(int change) {
        System.out.println("======");
        System.out.println(this);
        System.out.println("加热" + change + "度");
        x = waterState.heat(x, change);
        System.out.println(this);
        
    }
    
    public void cool(int change) {
        System.out.println("======");
        System.out.println(this);
        System.out.println("降低" + change + "度");
        x = waterState.cool(x, change);
        System.out.println(this);
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
    
    @Override
    public String toString() {
        return "此时此刻水的温度为" + x + "，水的状态为" + waterState.toString();
    }
}
