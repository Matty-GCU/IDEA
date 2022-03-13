package design.pattern.ch04.factory.example2;

public class DBLoggerFactory implements LoggerFactory {
    @Override
    public Logger getLogger() {
        return new DBLogger();
    }
}
