package design.pattern.第101112周上机.装饰模式.stablefood;

/**
 * 主食二选一：粉条
 */
public class Vermicelli extends Food {
    
    public Vermicelli() {
        price = 9;
    }
    
    @Override
    public int getPrice() {
        return price;
    }
}
