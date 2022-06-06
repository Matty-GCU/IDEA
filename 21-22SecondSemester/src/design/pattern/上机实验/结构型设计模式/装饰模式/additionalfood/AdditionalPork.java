package design.pattern.上机实验.结构型设计模式.装饰模式.additionalfood;

import design.pattern.上机实验.结构型设计模式.装饰模式.stablefood.Food;

public class AdditionalPork extends AdditionalFood {
    private int porkPrice;
    
    public AdditionalPork(Food food) {
        super(food);
        porkPrice = 3;
    }
    
    @Override
    public int getPrice() {
        return super.getPrice() + porkPrice;
    }
}
