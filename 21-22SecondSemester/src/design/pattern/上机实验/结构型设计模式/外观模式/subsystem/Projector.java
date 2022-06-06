package design.pattern.上机实验.结构型设计模式.外观模式.subsystem;

/**
 * 投影仪，单向关联幕布
 */
class Projector {
    
    private Screen screen;
    
    public Projector() {
        screen = new Screen();
    }
    
    public void turnOn() {
        System.out.println("启动投影仪！");
        screen.drop();
    }
    
    public void turnOff() {
        screen.raise();
        System.out.println("关闭投影仪！");
    }
}
