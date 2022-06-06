package design.pattern.上机实验.行为型设计模式.观察者模式;

/**
 * 充当观察者
 */
public class Pursuer {
    
    public void pursue(Girl girl) {
        girl.addPursuer(this);
    }
    
    public void getGirlsState(String state) {
        System.out.println("得知女孩现在的状态是" + state);
    }
}
