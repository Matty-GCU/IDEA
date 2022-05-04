package design.pattern.ch23.state.example2;

public class OnState extends SwitchState {
    @Override
    public void on(Switch s) {
        System.out.println("已经打开了");
    }
    
    @Override
    public void off(Switch s) {
        System.out.println("关闭成功！");
        Switch.setCurrentState(Switch.getState("off"));
    }
}
