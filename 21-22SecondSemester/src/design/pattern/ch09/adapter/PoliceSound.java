package design.pattern.ch09.adapter;

/**
 * 警笛类，充当适配者（Adaptee）
 */
public class PoliceSound {
    public void alarmSound() {
        System.out.println("发出警笛声音");
    }
}
