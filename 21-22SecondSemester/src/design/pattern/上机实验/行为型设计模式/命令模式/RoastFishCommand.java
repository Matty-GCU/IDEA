package design.pattern.上机实验.行为型设计模式.命令模式;

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
