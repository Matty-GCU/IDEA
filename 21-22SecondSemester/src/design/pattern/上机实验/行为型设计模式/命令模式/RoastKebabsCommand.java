package design.pattern.上机实验.行为型设计模式.命令模式;

/**
 * 具体命令类
 */
public class RoastKebabsCommand extends RoastCommand {
    
    BarbecueB barbecueB;
    
    public RoastKebabsCommand() {
        barbecueB = new BarbecueB();
    }
    
    @Override
    public void roast() {
        barbecueB.roastKebabs();
    }
}
