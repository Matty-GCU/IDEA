package design.pattern.第101112周上机.装饰模式.stablefood;

/**
 * 主食二选一：面条
 */
public class Noodle extends Food {
    
    public Noodle() {
        price = 10;
    }
    
    @Override
    public int getPrice() {
        return price;
    }
}
