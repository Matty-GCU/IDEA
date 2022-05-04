package design.pattern.第10周上机.外观模式.subsystem;

/**
 * 电脑，单向关联投影仪和麦克风
 */
public class Computer {
    
    private Projector projector;
    private Microphone microphone;
    
    public Computer() {
        projector = new Projector();
        microphone = new Microphone();
    }
    
    public void bootStrap() {
        System.out.println("电脑开机！");
        microphone.turnOn();
        projector.turnOn();
    }
    
    public void shutdown() {
        microphone.turnOff();
        projector.turnOff();
        System.out.println("电脑关机！");
    }
}
