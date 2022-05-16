package design.pattern.第101112周上机.装饰模式.additionalfood;

import design.pattern.第101112周上机.装饰模式.stablefood.Food;

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
