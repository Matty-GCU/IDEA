package design.pattern.ch14.flyweight.example1;

/**
 * 抽象享元类
 */
public abstract class Flyweight {
    
    /**
     * @param extrinsicState 外部状态
     */
    public abstract void operation(String extrinsicState);
}
