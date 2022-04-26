package design.pattern.ch19.iterator;

import java.util.List;

/**
 * 内部类实现迭代器
 */
public class ProductList2 extends AbstractObjectList {
    
    public ProductList2(List<Object> objects) {
        super(objects);
    }
    
    @Override
    public AbstractIterator createIterator() {
        return null;
    }
    
    /**
     * 和另外一个ProductIterator类完全一致。
     */
    private class ProductIterator implements AbstractIterator {
        
        protected List<Object> products;
        
        //用于记录正向遍历位置的游标
        private int cursor1;
        
        //用于记录逆向遍历位置的游标
        private int cursor2;
        
        public ProductIterator(ProductList productsList) {
            this.products = productsList.getObjects();
            cursor1 = 0;
            cursor2 = this.products.size() - 1;
        }
        
        //正向遍历
        @Override
        public void next() {
            if (cursor1 < products.size()) {
                cursor1++;
            }
        }
        
        @Override
        public boolean isLast() {
            return cursor1 == products.size();
        }
        
        @Override
        public Object getNextItem() {
            return products.get(cursor1);
        }
        
        
        //逆向遍历
        @Override
        public void previous() {
            if(cursor2 > -1) {
                cursor2--;
            }
        }
        
        @Override
        public boolean isFirst() {
            return cursor2 == -1;
        }
        
        @Override
        public Object getPreviousItem() {
            return products.get(cursor2);
        }
    }
}
