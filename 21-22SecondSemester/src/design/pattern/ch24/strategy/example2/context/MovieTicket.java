package design.pattern.ch24.strategy.example2.context;

import design.pattern.ch24.strategy.example2.strategy.Discount;

public class MovieTicket {
    private Discount discount;
    private double price;
    
    public MovieTicket(double price) {
        this.price = price;
    }
    
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    
    public double getPrice() {
        return discount.calculate(price);
    }
}
