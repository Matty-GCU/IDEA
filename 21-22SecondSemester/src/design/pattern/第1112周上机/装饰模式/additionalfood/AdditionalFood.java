package design.pattern.第1112周上机.装饰模式.additionalfood;

import design.pattern.第1112周上机.装饰模式.stablefood.Food;

public class AdditionalFood extends Food {
    protected Food food;
    
    public AdditionalFood(Food food) {
        this.food = food;
    }
    
    @Override
    public int getPrice() {
        return food.getPrice();
    }
}
