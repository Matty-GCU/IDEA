package design.pattern.上机实验.行为型设计模式.观察者模式;

/**
 * 充当具体观察者（ConcreteObserver）
 */
public class Pursuer {
    
    public void pursue(Girl girl) {
        girl.addPursuer(this);
    }
    
    /**
     * 响应方法
     * @param state
     */
    public void getGirlsState(String state) {
        System.out.println(this + "得知女孩现在的状态是" + state);
    }
}
