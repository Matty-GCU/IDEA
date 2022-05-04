package design.pattern.ch20.mediator;

public class ConcreteMediator extends Mediator {
    /**
     * 声明抽象的业务方法
     */
    @Override
    public void operation() {
        for (Colleague colleague : colleagues) {
            colleague.selfMethod1();
        }
    }
}
