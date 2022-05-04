package design.pattern.ch23.state.example1;

public class Test {
    public static void main(String[] args) {
        //1500正常
        Account account = new Account("吴先生", 1500);
        //2500正常
        account.deposit(1000);;
        //1正常
        account.withdraw(2499);
        //0正常
        account.withdraw(1);
        //-1900透支
        account.withdraw(1999);
        //-2000受限
        account.withdraw(1);
        //-2000受限（无法操作）
        account.withdraw(1);
    }
}
