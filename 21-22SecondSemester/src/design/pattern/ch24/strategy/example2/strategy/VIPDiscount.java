package design.pattern.ch24.strategy.example2.strategy;

public class VIPDiscount implements Discount {
    
    private final double DISCOUNT = 0.5;
    
    @Override
    public double calculate(double originPrice) {
        System.out.println("VIP票，打5折");
        System.out.println("增加" + originPrice + "积分！");
        return originPrice * DISCOUNT;
    }
}
