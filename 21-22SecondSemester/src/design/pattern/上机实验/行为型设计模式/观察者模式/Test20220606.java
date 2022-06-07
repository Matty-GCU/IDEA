package design.pattern.上机实验.行为型设计模式.观察者模式;

public class Test20220606 {
    public static void main(String[] args) {
        Girl huang = new Girl();
        Pursuer wu1 = new Pursuer();
        Pursuer wu2 = new Pursuer();
        Pursuer wu3 = new Pursuer();
        Pursuer wu4 = new Pursuer();
        wu1.pursue(huang);
        wu2.pursue(huang);
        wu3.pursue(huang);
        wu4.pursue(huang);
        huang.setState("有空");
    }
}
