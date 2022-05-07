package design.pattern.第1112周上机.装饰模式.additionalfood;

public class AdditionalBeef extends AdditionalFood {
    @Override
    public int getPrice() {
        return stableFood.getPrice() + 5;
    }
}
