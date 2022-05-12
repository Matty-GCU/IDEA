package design.pattern.ch25.templatemethod;

public class TestTemplate {
    public static void main(String[] args) {
        Account account = new CurrentAccount();
        account.handle("正确账户", "对应的正确密码");
    }
}
