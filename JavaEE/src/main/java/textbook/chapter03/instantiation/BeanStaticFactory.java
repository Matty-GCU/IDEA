package textbook.chapter03.instantiation;

public class BeanStaticFactory {
    private static BeanClass beanClassInstance = new BeanClass("调用静态工厂方法实例化Bean");
    public static BeanClass getInstance() {
        return beanClassInstance;
    }
}
