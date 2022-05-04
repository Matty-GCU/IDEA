package design.pattern.第10周上机.外观模式.subsystem;

/**
 * 幕布
 */
class Screen {
    public void drop() {
        System.out.println("放下幕布");
    }
    
    public void raise() {
        System.out.println("收起幕布");
    }
}
