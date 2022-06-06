package design.pattern.上机实验.结构型设计模式.适配器模式;

public class Client {
    public static void main(String[] args) {
        Payment payment = new AbroadPaymentAdapter();
        payment.pay(60);
    }
}
