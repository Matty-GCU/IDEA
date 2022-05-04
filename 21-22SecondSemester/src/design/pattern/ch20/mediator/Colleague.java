package design.pattern.ch20.mediator;

public abstract class Colleague {
    protected Mediator mediator;
    
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
    
    /**
     * 自身方法
     */
    public abstract void selfMethod1();
    
    /**
     * 依赖方法
     */
    public abstract void dependMethod();
    
    
}
