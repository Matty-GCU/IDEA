package design.pattern.ch15.proxy.example2;

public class Logger {
    public void log(String userId) {
        System.out.println("更新数据库，用户" + userId + "查询次数+1");
    }
}
