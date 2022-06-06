package design.pattern.上机实验.行为型设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 充当被观察者
 */
public class Girl {
    
    String state;
    List<Pursuer> pursuerList;
    
    public Girl() {
        state = "";
        pursuerList = new ArrayList<>();
    }
    
    public void addPursuer(Pursuer pursuer) {
        pursuerList.add(pursuer);
    }
    
    public void update(String newState) {
        state = newState;
        for (Pursuer pursuer : pursuerList) {
            pursuer.getGirlsState(state);
        }
    }
    
}
