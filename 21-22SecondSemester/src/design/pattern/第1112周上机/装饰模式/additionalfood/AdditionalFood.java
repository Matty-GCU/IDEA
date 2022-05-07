package design.pattern.第1112周上机.装饰模式.additionalfood;

import design.pattern.第1112周上机.装饰模式.stablefood.StableFood;

public abstract class AdditionalFood extends StableFood {
    protected StableFood stableFood;
    
    public void setStableFood(StableFood stableFood) {
        this.stableFood = stableFood;
    }
}
