package design.pattern.ch23.state.example2;

public class OffState extends SwitchState {
    @Override
    public void on(Switch s) {
        System.out.println("关闭");
        Switch.setCurrentState(Switch.getState("off"));
    }
    
    @Override
    public void off(Switch s) {
        System.out.println("已经关闭了");
        Switch.setCurrentState(Switch.getState("off"));
    }
}
