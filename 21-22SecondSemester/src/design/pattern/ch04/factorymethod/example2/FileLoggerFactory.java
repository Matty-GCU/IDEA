package design.pattern.ch04.factorymethod.example2;

public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger getLogger() {
        return new FileLogger();
    }
}
