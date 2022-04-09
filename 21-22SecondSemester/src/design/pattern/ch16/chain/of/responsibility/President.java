package design.pattern.ch16.chain.of.responsibility;

public class President extends AbstractApprover {
    
    public President(String name) {
        super(name);
    }
    @Override
    public void handleRequest(PurchaseReuqest reuqest) {
        if(reuqest.getAmount() < 500000) {
            System.out.println(name + "董事长审核（金额不超过50万的）采购单：" + reuqest.toString());
        } else {
            successor.handleRequest(reuqest);
        }
    }
}
