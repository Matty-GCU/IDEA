package design.pattern.第13周上机.命令模式;

/**
 * 具体命令类
 */
public class RoastFishCommand extends RoastCommand {
    
    BarbecueA barbecueA;
    
    public RoastFishCommand() {
        barbecueA = new BarbecueA();
    }
    
    @Override
    public void roast() {
        barbecueA.roastFish();
    }
}
