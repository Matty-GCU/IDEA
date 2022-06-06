package design.pattern.上机实验.结构型设计模式.外观模式;

import design.pattern.上机实验.结构型设计模式.外观模式.subsystem.Computer;
import design.pattern.上机实验.结构型设计模式.外观模式.subsystem.Light;

/**
 * 一键下课按钮，充当外观类
 */
public class StartClassButton {
    
    Light light;
    Computer computer;
//    Projector projector;
//    Screen screen;
//    Microphone microphone;
    
    
    public StartClassButton() {
        light = new Light();
        computer = new Computer();
    }
    
    /**
     * 按下按钮
     */
    public void start() {
        light.turnOn();
        computer.bootStrap();
    }
}
