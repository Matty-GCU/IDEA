package design.pattern.ch16.chain.of.responsibility;

public class VicePresident extends AbstractApprover {
    
    public VicePresident(String name) {
        super(name);
    }
    
    @Override
    public void handleRequest(PurchaseReuqest reuqest) {
        if(reuqest.getAmount() < 100000) {
            System.out.println(name + "副董事长审核（金额不超过10万的）采购单：" + reuqest.toString());
        } else {
            successor.handleRequest(reuqest);
        }
    }
}
