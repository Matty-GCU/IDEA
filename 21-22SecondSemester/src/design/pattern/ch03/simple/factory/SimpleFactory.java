package design.pattern.ch03.simple.factory;

public class SimpleFactory {
    
    public static Product getProduct(String arg) {
        Product product = null;
        if ("A".equals(arg)) {
            product = new ProductA();
        } else if ("B".equals(arg)) {
            product = new ProductB();
        }
        return product;
    }
}
