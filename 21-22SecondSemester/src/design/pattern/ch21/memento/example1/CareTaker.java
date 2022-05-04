package design.pattern.ch21.memento.example1;

/**
 * 负责人
 * 它的作用仅仅是存储一个或多个备忘录对象，而不能修改对象，也无须知道对象的实现细节
 */
public class CareTaker {
    private Memento memento;
    
    public Memento getMemento() {
        return memento;
    }
    
    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
