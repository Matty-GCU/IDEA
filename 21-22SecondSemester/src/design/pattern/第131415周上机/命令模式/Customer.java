package design.pattern.第131415周上机.命令模式;

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
