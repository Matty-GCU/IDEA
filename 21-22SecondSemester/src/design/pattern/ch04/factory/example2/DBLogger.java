package design.pattern.ch04.factory.example2;

public class DBLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录");
    }
}
