package design.pattern.ch03.simple.factory;

public class ProductB extends Product {
    
    /**
     * 各个产品的独特功能
     */
    @Override
    public void methodDiff() {
        System.out.println("产品B的独特功能");
    }
    
}

