package design.pattern.ch20.mediator;

import java.util.ArrayList;

public abstract class Mediator {
    protected ArrayList<Colleague> colleagues = new ArrayList<>();
    
    /**
     * 注册方法，用于增加同事对象
     */
    public void register(Colleague newColleague) {
        colleagues.add(newColleague);
    }
    
    /**
     * 声明抽象的业务方法
     */
    public abstract void operation();
    
}
