package design.pattern.上机实验.结构型设计模式.装饰模式.additionalfood;

import design.pattern.上机实验.结构型设计模式.装饰模式.stablefood.Food;

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
