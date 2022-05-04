package design.pattern.第10周上机.外观模式;

public class Client {
    public static void main(String[] args) {
        StartClassButton startClassButton = new StartClassButton();
        startClassButton.start();
        System.out.println("===============");
        EndClassButton endClassButton = new EndClassButton();
        endClassButton.end();
    }
}
