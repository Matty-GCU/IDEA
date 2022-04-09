package design.pattern.ch16.chain.of.responsibility;

public class Director extends AbstractApprover {
    
    public Director(String name) {
        super(name);
    }
    
    @Override
    public void handleRequest(PurchaseReuqest reuqest) {
        if(reuqest.getAmount() < 10000) {
            System.out.println(name + "主任审核（金额不超过1万的）采购单：" + reuqest.toString());
        } else {
            successor.handleRequest(reuqest);
        }
    }
}
