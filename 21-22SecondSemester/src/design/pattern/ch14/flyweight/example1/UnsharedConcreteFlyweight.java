package design.pattern.ch14.flyweight.example1;

/**
 * 非共享具体享元类
 */
public class UnsharedConcreteFlyweight extends Flyweight {
    
    /**
     * @param extrinsicState 外部状态
     */
    @Override
    public void operation(String extrinsicState) {
        //具体业务实现
    }
}
