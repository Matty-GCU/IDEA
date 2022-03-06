package textbook.chapter03.instantiation;

public class BeanInstanceFactory {
    public BeanClass createInstance() {
        return new BeanClass("调用实例工厂方法实例化Bean");
    }
}
