package design.pattern.上机实验.结构型设计模式.装饰模式.additionalfood;

import design.pattern.上机实验.结构型设计模式.装饰模式.stablefood.Food;

public class AdditionalEgg extends AdditionalFood {
    private int eggPrice;
    
    public AdditionalEgg(Food food) {
        super(food);
        eggPrice = 2;
    }
    
    @Override
    public int getPrice() {
        return super.getPrice() + eggPrice;
    }
}
