package design.pattern.第10周上机.适配器模式;

public class Client {
    public static void main(String[] args) {
        Payment payment = new AbroadPaymentAdapter();
        payment.pay(60);
    }
}
