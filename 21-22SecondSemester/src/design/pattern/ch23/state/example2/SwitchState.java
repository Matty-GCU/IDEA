package design.pattern.ch23.state.example2;

public abstract class SwitchState {
    public abstract void on(Switch s);
    public abstract void off(Switch s);
}
