package design.pattern.ch14.flyweight.example1;

/**
 * 具体享元类
 */
public class ConcreteFlyweight extends Flyweight {
    
    /**
     * 内部状态作为成员变量，同一个享元对象的内部状态是唯一的
     */
    private String intrinsicState;
    
    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }
    
    /**
     * @param extrinsicState 外部状态作为方法参数，在使用时由外部设置，不保存在享元对象中。即使是同一个对象，在每一次调用时也可以传入不同的外部状态
     */
    @Override
    public void operation(String extrinsicState) {
        //实现业务方法
    }
}
