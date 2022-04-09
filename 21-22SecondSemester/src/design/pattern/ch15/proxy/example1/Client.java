package design.pattern.ch15.proxy.example1;

public class Client {
    public static void main(String[] args) {
        AbstractSubject proxy = new Proxy();
        proxy.request();
    }
}
