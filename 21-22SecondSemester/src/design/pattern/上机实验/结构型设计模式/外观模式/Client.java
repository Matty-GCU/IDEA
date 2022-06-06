package design.pattern.上机实验.结构型设计模式.外观模式;

public class Client {
    public static void main(String[] args) {
        StartClassButton startClassButton = new StartClassButton();
        startClassButton.start();
        System.out.println("===============");
        EndClassButton endClassButton = new EndClassButton();
        endClassButton.end();
    }
}
