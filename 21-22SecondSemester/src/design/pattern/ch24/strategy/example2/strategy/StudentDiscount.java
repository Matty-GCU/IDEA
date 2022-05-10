package design.pattern.ch24.strategy.example2.strategy;

public class StudentDiscount implements Discount {
    
    private final double DISCOUNT = 0.8;
    
    @Override
    public double calculate(double originPrice) {
        System.out.println("学生票，打8折");
        return originPrice * DISCOUNT;
    }
}
