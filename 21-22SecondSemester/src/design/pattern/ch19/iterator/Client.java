package design.pattern.ch19.iterator;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Object> products = new ArrayList<>();
        products.add("111");
        products.add("222");
        products.add("333");
        products.add("444");
        AbstractObjectList productList = new ProductList(products);
        AbstractIterator iterator = productList.createIterator();
        System.out.println("正向遍历");
        while (! iterator.isLast()) {
            System.out.println(iterator.getNextItem());
            iterator.next();
        }
        System.out.println("逆向遍历");
        while (! iterator.isFirst()) {
            System.out.println(iterator.getPreviousItem());
            iterator.previous();
        }
    }
}
