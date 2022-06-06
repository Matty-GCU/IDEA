package design.pattern.上机实验.结构型设计模式.适配器模式;

/**
 * 国内的支付系统
 * 充当目标类
 */
public interface Payment {
    void pay(double money);
}
