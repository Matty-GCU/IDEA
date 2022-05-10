package design.pattern.ch24.strategy.example2.strategy;

public class ChildrenDiscount implements Discount {
    
    private final double DISCOUNT = 10;
    
    @Override
    public double calculate(double originPrice) {
        System.out.println("儿童票，20元以上的票减少10元");
        if(originPrice >= 20) {
            return originPrice - DISCOUNT;
        }
        else {
            return originPrice;
        }
    }
}
