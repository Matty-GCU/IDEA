package design.pattern.第10周上机.适配器模式;

/**
 * 适配器类
 * 使用了类适配器模式，不是对象适配器
 */
public class AbroadPaymentAdapter extends AbroadPayment implements Payment {
    
    @Override
    public void pay(double money) {
        //假设人民币:美元的汇率是6:1
        super.pay(money / 6);
    }
}
