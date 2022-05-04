package design.pattern.ch23.state.example1;

public class RestrictedState extends AccountState {
    
    public RestrictedState(Account account) {
        this.account = account;
    }
    
    /**
     * 存款
     */
    @Override
    public void deposit(double amount) {
        double finalBalance = account.getBalance() + amount;
        if (checkState(finalBalance)) {
            account.setBalance(finalBalance);
        }
    }
    
    /**
     * 取款
     */
    @Override
    public void withdraw(double amount) {
        double finalBalance = account.getBalance() - amount;
        if (checkState(finalBalance)) {
            account.setBalance(finalBalance);
        }
    }
    
    /**
     * 计算利息
     */
    @Override
    public void computeInterest() {
        System.out.println("计算利息方式二");
    }
    
    /**
     * 检查状态（这个方法我写得和课本很不一样）
     */
    @Override
    public boolean checkState(double finalBalance) {
        if (finalBalance < -2000) {
            System.out.println("无法操作！");
            return false;
        }
        if (finalBalance < 0 && finalBalance > -2000) {
            account.setState(new OverdraftState(account));
        } else if (finalBalance == -2000) {
            account.setState(new RestrictedState(account));
        } else {
            // finalBalance >= 0
            // 不需要改变账户状态
        }
        return true;
    }
    
    /**
     * 获取状态名（这个方法是我自己加的，课本里没有）
     */
    @Override
    public String getStateName() {
        return "受限状态";
    }
}
