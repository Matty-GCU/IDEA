package design.pattern.第131415周上机.命令模式;

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
