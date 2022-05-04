package design.pattern.ch21.memento.example1;

/**
 * 备忘录对象
 */
class Memento {
    private String state;
    
    public Memento(Originator originator) {
        this.state = originator.getState();
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
}
