package design.pattern.第10周上机.适配器模式;

/**
 * 国内的支付系统
 * 充当目标类
 */
public interface Payment {
    void pay(double money);
}
