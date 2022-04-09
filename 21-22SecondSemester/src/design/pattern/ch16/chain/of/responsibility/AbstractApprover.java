package design.pattern.ch16.chain.of.responsibility;

public abstract class AbstractApprover {
    
    /**
     * 后续对象
     */
    protected AbstractApprover successor;
    
    /**
     * 审核者姓名
     */
    protected String name;
    
    public AbstractApprover(String name) {
        this.name = name;
    }
    
    public void setSuccessor(AbstractApprover successor) {
        this.successor = successor;
    }
    
    public abstract void handleRequest(PurchaseReuqest reuqest);
}
