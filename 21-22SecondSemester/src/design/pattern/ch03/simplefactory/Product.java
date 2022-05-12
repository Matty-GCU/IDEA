package design.pattern.ch03.simplefactory;

public abstract class Product {
    
    public void methodSame() {
        System.out.println("所有产品都具备的功能");
    }
    
    /**
     * 各个产品的独特功能
     */
    public abstract void methodDiff();
}
