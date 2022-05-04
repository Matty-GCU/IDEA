package design.pattern.ch23.state.example2;

public class Switch {
    private static SwitchState currentState;
    private static SwitchState onState = new OnState();
    private static SwitchState offState = new OffState();
    private String name;
    
    Switch(String name) {
        this.name = name;
        currentState = onState;
    }
    
    public static void setCurrentState(SwitchState currentState) {
        Switch.currentState = currentState;
    }
    
    public static SwitchState getState(String type) {
        if ("on".equals(type)) {
            return onState;
        } else {
            return offState;
        }
    }
    
    public void on() {
        System.out.print(name);
        currentState.on(this);
    }
    
    public void off() {
        System.out.print(name);
        currentState.off(this);
    }
}
