package design.pattern.ch04.factorymethod.example1;

import design.pattern.ch03.simplefactory.Product;
import design.pattern.ch03.simplefactory.ProductA;

public class ProductAFactory implements Factory {
    /**
     * Factory Method
     */
    @Override
    public Product getProduct() {
        return new ProductA();
    }
}
