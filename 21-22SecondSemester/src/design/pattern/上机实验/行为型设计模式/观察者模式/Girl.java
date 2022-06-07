package design.pattern.上机实验.行为型设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 充当具体目标（ConcreteSubject）
 */
public class Girl {
    
    String state;
    
    /**
     * 定义一个观察者集合，用于存储所有观察者对象
     */
    List<Pursuer> pursuerList;
    
    public Girl() {
        state = "";
        pursuerList = new ArrayList<>();
    }
    
    /**
     * 注册方法，用于向观察者集合中增加一个观察者
     */
    public void addPursuer(Pursuer pursuer) {
        pursuerList.add(pursuer);
    }
    
    /**
     * 通知方法
     */
    public void setState(String newState) {
        state = newState;
        for (Pursuer pursuer : pursuerList) {
            pursuer.getGirlsState(state);
        }
    }
    
}
