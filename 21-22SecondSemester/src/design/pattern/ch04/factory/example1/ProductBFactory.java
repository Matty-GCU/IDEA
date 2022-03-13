package design.pattern.ch04.factory.example1;

import design.pattern.ch03.simple.factory.Product;
import design.pattern.ch03.simple.factory.ProductB;

public class ProductBFactory implements Factory {
    /**
     * Factory Method
     */
    @Override
    public Product getProduct() {
        return new ProductB();
    }
}
