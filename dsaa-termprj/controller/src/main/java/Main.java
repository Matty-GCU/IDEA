import system.ControllingSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("欢迎进入【网约车管理系统】。");
        System.out.println("请先登录：");
        System.out.println("选择您的身份：输入1（乘客），输入2（司机），输入3（管理员），输入4");
        new ControllingSystem().play();
    }
}
