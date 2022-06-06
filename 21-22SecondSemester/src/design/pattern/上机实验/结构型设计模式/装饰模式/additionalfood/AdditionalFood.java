package design.pattern.上机实验.结构型设计模式.装饰模式.additionalfood;

import design.pattern.上机实验.结构型设计模式.装饰模式.stablefood.Food;

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
