package design.pattern.ch04.factory.example2;

public class FileLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("文件日志记录");
    }
}
