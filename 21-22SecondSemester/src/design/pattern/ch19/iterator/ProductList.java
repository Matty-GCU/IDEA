package design.pattern.ch19.iterator;

import java.util.List;

public class ProductList extends AbstractObjectList {
    
    public ProductList(List<Object> objects) {
        super(objects);
    }
    
    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}
