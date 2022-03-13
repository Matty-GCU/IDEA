package design.pattern.ch04.factory.example2;

public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger getLogger() {
        return new FileLogger();
    }
}
