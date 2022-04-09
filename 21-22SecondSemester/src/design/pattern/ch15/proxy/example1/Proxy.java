package design.pattern.ch15.proxy.example1;

public class Proxy extends AbstractSubject {
    
    private RealSubject realSubject = new RealSubject();
    
    @Override
    public void request() {
        preRequest();
        realSubject.request();
        postRequest();
    }
    
    public void preRequest() {
        System.out.println("preRequest");
    }
    
    public void postRequest() {
        System.out.println("postRequest");
    }
}
