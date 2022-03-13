package design.pattern.ch04.factory.example1;

import design.pattern.ch03.simple.factory.Product;

/**
 * 工厂模式（Factory Pattern）
 * or 虚拟构造器模式（Virtual Constructor Pattern）
 * or 多态工厂模式（Polymorphic Factory Pattern）
 */
public interface Factory {
    /**
     * Factory Method
     */
    Product getProduct();
}
