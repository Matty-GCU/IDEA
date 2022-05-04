package design.pattern.ch21.memento.example1;

public class Client {
    public static void main(String[] args) {
        Originator o = new Originator();
        o.setState("旧状态");
        System.out.println(o.getState());
        CareTaker careTaker = new CareTaker();
        careTaker.setMemento(o.createMemento());
        
        o.setState("新状态");
        System.out.println(o.getState());
        //undo
        o.restoreMemento(careTaker.getMemento());
        System.out.println(o.getState());
    }
}
