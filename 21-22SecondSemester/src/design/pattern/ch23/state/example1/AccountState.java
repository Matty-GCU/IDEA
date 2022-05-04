package design.pattern.ch23.state.example1;

/**
 * 账户状态类，充当抽象状态类
 */
public abstract class AccountState {
    
    protected Account account;
    
    public void setAccount(Account account) {
        this.account = account;
    }
    
    /**
     * 存款
     */
    public abstract void deposit(double amount);
    
    /**
     * 取款
     */
    public abstract void withdraw(double amount);
    
    /**
     * 计算利息
     */
    public abstract void computeInterest();
    
    /**
     * 检查状态
     */
    public abstract boolean checkState(double finalBalance);
    
    /**
     * 获取状态名（这个方法是我自己加的，课本里没有）
     */
    public abstract String getStateName();
}
