package design.pattern.上机实验.结构型设计模式.装饰模式.stablefood;

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
