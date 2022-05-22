package design.pattern.第13周上机.命令模式;

/**
 * 具体命令类
 */
public class RoastChikenWingsCommand extends RoastCommand {
    
    BarbecueB barbecueB;
    
    public RoastChikenWingsCommand() {
        barbecueB = new BarbecueB();
    }
    
    @Override
    public void roast() {
        barbecueB.roastChickenWings();
    }
}
