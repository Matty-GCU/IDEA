package design.pattern.ch21.memento.example1;

/**
 * 原发器
 */
public class Originator {
    private String state;
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public Memento createMemento() {
        return new Memento(this);
    }
    
    public void restoreMemento(Memento memento) {
        setState(memento.getState());
    }
    
}
