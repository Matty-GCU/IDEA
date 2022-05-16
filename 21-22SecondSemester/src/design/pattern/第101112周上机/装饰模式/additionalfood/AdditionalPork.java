package design.pattern.第101112周上机.装饰模式.additionalfood;

import design.pattern.第101112周上机.装饰模式.stablefood.Food;

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
