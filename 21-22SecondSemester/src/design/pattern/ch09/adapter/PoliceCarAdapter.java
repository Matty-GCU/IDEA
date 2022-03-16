package design.pattern.ch09.adapter;

/**
 * 适配器模式（Adapter Pattern）/包装器模式（Wrapper Pattern）
 * 这里是【对象适配器】的实现机制。
 *
 * 警车适配器，充当适配器（Adapter）
 */
public class PoliceCarAdapter extends CarController {
    
    PoliceSound policeSound;
    PoliceLamp policeLamp;
    
    public PoliceCarAdapter() {
        policeSound = new PoliceSound();
        policeLamp = new PoliceLamp();
    }
    
    /**
     * 发出声音
     */
    @Override
    public void phonate() {
        policeSound.alarmSound();
    }
    
    /**
     * 灯光闪烁
     */
    @Override
    public void twinkle() {
        policeLamp.alarmLamp();
    }
}
