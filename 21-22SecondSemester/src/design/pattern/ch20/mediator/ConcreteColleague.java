package design.pattern.ch20.mediator;

public class ConcreteColleague extends Colleague {
    
    public ConcreteColleague(Mediator mediator) {
        super(mediator);
        mediator.register(this);
    }
    
    /**
     * 自身方法
     */
    @Override
    public void selfMethod1() {
        // ...
    }
    
    /**
     * 依赖方法
     */
    @Override
    public void dependMethod() {
        mediator.operation();
    }
}
