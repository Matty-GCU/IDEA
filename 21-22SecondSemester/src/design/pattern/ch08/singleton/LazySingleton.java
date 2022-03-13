package design.pattern.ch08.singleton;

public class LazySingleton {
    
    /**
     * 第三个版本必须使用volatile修饰该类变量
     */
    private volatile static LazySingleton instance;
    
    private LazySingleton() {}
    
    /**
     * 初始版本，第一次调用该方法需要实例化，在类加载时不自行实例化，即懒加载
     * 但是无法应对并发情况（多个线程同时调用该方法）
     */
    public static LazySingleton getInstance1() {
        //Lazy Load
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
    /**
     * 第二个版本，使用synchronized修饰该方法，对整个方法加锁，确保任意时刻只有一个线程可以执行该方法
     * 但是在高并发环境下效率太低
     */
    public static synchronized LazySingleton getInstance2() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
    /**
     * 第三个版本，使用synchronized代码块减小锁的粒度，若instance此前已被实例化，则无需加锁，不影响效率。
     * 新知识：synchronized代码块、volatile关键字
     * 但是安全检查繁琐，而且性能还是受影响（如果实例化需要的时间特别久，那么多个线程同时试图实例化此类的几率就会很大）
     */
    public static LazySingleton getInstance3() {
        //Double-Check Locking
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
    
}
