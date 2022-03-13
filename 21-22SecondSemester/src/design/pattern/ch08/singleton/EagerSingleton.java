package design.pattern.ch08.singleton;

public class EagerSingleton {
    
    /**
     * 为什么能够保证线程安全性？因为这个变量的初始化发生在这个类加载的时候，而类的加载由JVM做优化，不可能重复加载、重复new
     */
    private static EagerSingleton instance = new EagerSingleton();
    
    private EagerSingleton() {}
    
    public static EagerSingleton getInstance() {
        return instance;
    }
}
