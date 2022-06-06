package design.pattern.上机实验.结构型设计模式.适配器模式;

/**
 * 国外的支付系统
 * 充当适配者类
 */
public class AbroadPayment {
    public void pay(double money) {
        System.out.println("支付美元" + money + "元");
    }
}
