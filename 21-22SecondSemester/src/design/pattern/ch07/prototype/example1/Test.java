package design.pattern.ch07.prototype.example1;

public class Test {
    public static void main(String[] args) {
        ConcretePrototype concretePrototype1 = new ConcretePrototype();
        concretePrototype1.setAttribute("属性值111");
        System.out.println(concretePrototype1.getAttribute());
    
        ConcretePrototype concretePrototype2 = (ConcretePrototype) concretePrototype1.clonePrototype();
        System.out.println(concretePrototype2.getAttribute());
    }
}
