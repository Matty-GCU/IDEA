package design.pattern.ch04.factorymethod.example1;

import design.pattern.ch03.simplefactory.Product;
import design.pattern.ch03.simplefactory.ProductB;

public class ProductBFactory implements Factory {
    /**
     * Factory Method
     */
    @Override
    public Product getProduct() {
        return new ProductB();
    }
}
