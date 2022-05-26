package design.pattern.第131415周上机.命令模式;

/**
 * 命令调用者
 */
public class Waiter {
    
    RoastCommand roastCommand;
    
    public void setRoastCommand(RoastCommand roastCommand) {
        this.roastCommand = roastCommand;
    }
    
    public void startRoast() {
        roastCommand.roast();
    }
}
