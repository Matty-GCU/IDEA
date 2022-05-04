package design.pattern.ch23.state.example1;

/**
 * 银行账户类，充当环境类
 */
public class Account {
    
    /**
     * 维持一个对抽象状态对象的引用
     */
    private AccountState state;
    
    /**
     * 开户名
     */
    private String owner;
    
    /**
     * 账户余额
     */
    private double balance;
    
    public Account(String owner, double initBalance) {
        this.owner = owner;
        this.balance = initBalance;
        System.out.println(owner + "开户, 金额为" + initBalance + "（金额必定为正数）");
        this.state = new NormalState(this);
    }
    
    public void deposit(double amount) {
        System.out.println(this.owner + "存入" + amount);
        state.deposit(amount);
        System.out.println("现在账户余额为" + this.balance);
        System.out.println("现在账户状态为" + this.state.getStateName());
        System.out.println("==========================");
    }
    
    public void withdraw(double amount) {
        System.out.println(this.owner + "取出" + amount);
        state.withdraw(amount);
        System.out.println("现在账户余额为" + this.balance);
        System.out.println("现在账户状态为" + this.state.getStateName());
        System.out.println("==========================");
    }
    
    public void computeInterest() {
        this.state.computeInterest();
    }
    
    
    public AccountState getState() {
        return state;
    }
    
    public void setState(AccountState state) {
        this.state = state;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
