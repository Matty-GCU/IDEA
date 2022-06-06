package design.pattern.上机实验.行为型设计模式.观察者模式;

public class Test20220606 {
    public static void main(String[] args) {
        Girl huang = new Girl();
        Pursuer wu1 = new Pursuer();
        Pursuer wu2 = new Pursuer();
        Pursuer wu3 = new Pursuer();
        Pursuer wu4 = new Pursuer();
        huang.addPursuer(wu1);
        huang.addPursuer(wu2);
        huang.addPursuer(wu3);
        huang.addPursuer(wu4);
        huang.update("有空");
    }
}
