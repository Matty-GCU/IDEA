package design.pattern.第10周上机.外观模式;

import design.pattern.第10周上机.外观模式.subsystem.Computer;
import design.pattern.第10周上机.外观模式.subsystem.Light;

/**
 * 一键上课按钮，充当外观类
 */
public class EndClassButton {
    Light light;
    Computer computer;
//    Projector projector;
//    Screen screen;
//    Microphone microphone;
    
    
    public EndClassButton() {
        light = new Light();
        computer = new Computer();
    }
    
    /**
     * 按下按钮
     */
    public void end() {
        light.turnOff();
        computer.shutdown();
    }
}
