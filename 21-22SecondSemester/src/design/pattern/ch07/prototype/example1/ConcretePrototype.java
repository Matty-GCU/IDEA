package design.pattern.ch07.prototype.example1;

public class ConcretePrototype extends Prototype {
    private String attribute;
    
    @Override
    public Prototype clonePrototype() {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setAttribute(this.getAttribute());
        // 也可以不显示地向上转型，因为返回类型是父类，所以最终也会强转
        // casting 'concretePrototype' to 'Prototype' is redundant
        return (Prototype) concretePrototype;
    }
    
    public String getAttribute() {
        return attribute;
    }
    
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    
}
