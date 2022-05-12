package design.pattern.ch25.templatemethod;

/**
 * 账户类，充当抽象类
 */
public abstract class Account {
    
    /**
     * 模板方法
     */
    public void handle(String account, String password) {
        if(! validate(account, password)) {
            System.out.println("账户或密码错误");
            return;
        }
        calculateInterest();
        display();
    }
    
    /**
     * 基本方法之具体方法
     */
    public boolean validate(String account, String password) {
        System.out.println("账号" + account);
        System.out.println("密码" + password);
        if (account.equals("正确账户") && password.equals("对应的正确密码")) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * 基本方法之抽象方法
     */
    public abstract void calculateInterest();
    
    /**
     * 基本方法之具体方法
     */
    public void display() {
        System.out.println("显示利息");
    }
}
