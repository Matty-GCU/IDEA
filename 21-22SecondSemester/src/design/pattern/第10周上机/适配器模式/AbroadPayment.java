package design.pattern.第10周上机.适配器模式;

/**
 * 国外的支付系统
 * 充当适配者类
 */
public class AbroadPayment {
    public void pay(double money) {
        System.out.println("支付美元" + money + "元");
    }
}
