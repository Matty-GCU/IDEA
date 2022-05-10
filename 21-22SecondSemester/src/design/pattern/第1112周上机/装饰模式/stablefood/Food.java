package design.pattern.第1112周上机.装饰模式.stablefood;

/**
 * 主食
 */
public abstract class Food {
    
    protected int price;
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public abstract int getPrice();
}
