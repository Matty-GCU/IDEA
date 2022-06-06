package design.pattern.上机实验.行为型设计模式.命令模式;

public class Customer {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
//        RoastCommand roastCommand = new RoastFishCommand();
//        RoastCommand roastCommand = new RoastKebabsCommand();
        RoastCommand roastCommand = new RoastChikenWingsCommand();
        waiter.setRoastCommand(roastCommand);
        waiter.startRoast();
    }
}
