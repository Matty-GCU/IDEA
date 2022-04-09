package design.pattern.ch15.proxy.example2;

public class AccessValidator {
    public boolean validate(String userId) {
        System.out.println("在数据库中验证" + userId + "是否为合法用户");
        if("合法用户的ID".equals(userId)) {
            System.out.println(userId + "登录成功！");
            return true;
        }
        else {
            System.out.println(userId + "登录失败！");
            return false;
        }
    }
}
