package design.pattern.第101112周上机.装饰模式.additionalfood;

import design.pattern.第101112周上机.装饰模式.stablefood.Food;

public class AdditionalBeef extends AdditionalFood {
    
    private int beefPrice;
    
    public AdditionalBeef(Food food) {
        super(food);
        beefPrice = 5;
    }
    
    @Override
    public int getPrice() {
        return super.getPrice() + beefPrice;
    }
}
