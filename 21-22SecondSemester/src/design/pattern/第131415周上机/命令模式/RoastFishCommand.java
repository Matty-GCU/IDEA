package design.pattern.第131415周上机.命令模式;

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
