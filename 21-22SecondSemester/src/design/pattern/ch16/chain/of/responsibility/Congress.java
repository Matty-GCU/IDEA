package design.pattern.ch16.chain.of.responsibility;

public class Congress extends AbstractApprover {
    
    public Congress(String name) {
        super(name);
    }
    
    @Override
    public void handleRequest(PurchaseReuqest reuqest) {
        System.out.println("召开董事会审批（金额大于或等于50万的）采购单：" + reuqest);
    }
}
