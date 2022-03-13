package design.pattern.ch08.singleton;

/**
 * 通过Initialization on Demand Holder技术来实现单例模式
 * 既可以实现懒加载，又可以保证线程安全，还不影响系统性能
 */
public class IoDHSingleton {
    
    private IoDHSingleton() {}
    
    private static class HolderClass {
        //由于加了final，所以JVM保证其线程安全性，确保该成员变量除了第一次初始化之外，不能进行写操作，只能进行读操作
        private final static IoDHSingleton INSTANCE = new IoDHSingleton();
    }
    
    /**
     * 懒加载：只有在第一次调用这个方法时，才会加载内部类HolderClass，此时其类变量将被初始化
     */
    public static IoDHSingleton getInstance() {
        return HolderClass.INSTANCE;
    }
    
}
