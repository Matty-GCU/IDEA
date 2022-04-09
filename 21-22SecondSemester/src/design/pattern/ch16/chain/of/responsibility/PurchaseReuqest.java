package design.pattern.ch16.chain.of.responsibility;

public class PurchaseReuqest {
    
    /**
     * 采购金额
     */
    private double amount;
    
    /**
     * 采购单编号
     */
    private int id;
    
    /**
     * 采购目的
     */
    private String purpose;
    
    public PurchaseReuqest(double amount, int id, String purpose) {
        this.amount = amount;
        this.id = id;
        this.purpose = purpose;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPurpose() {
        return purpose;
    }
    
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
    @Override
    public String toString() {
        return "采购单" +
                "编号=" + id +
                ", 金额=" + amount +
                ", 采购目的='" + purpose + '\'';
    }
}
