package design.pattern.ch04.factorymethod.example1;

import design.pattern.ch03.simplefactory.Product;
import design.pattern.ch04.factorymethod.XMLUtil;

public class Test {
    public static void main(String[] args) {
        Factory factory = (Factory) XMLUtil.getObjectFromXMLByTagName("src/design/pattern/ch04/factory/example1/config.xml", "product");
        Product product = (Product) factory.getProduct();
        product.methodDiff();
    }
}
