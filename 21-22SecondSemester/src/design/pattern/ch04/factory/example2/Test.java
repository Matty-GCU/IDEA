package design.pattern.ch04.factory.example2;

import design.pattern.ch04.factory.XMLUtil;

public class Test {
    public static void main(String[] args) {
//        LoggerFactory loggerFactory = new DBLoggerFactory();
        LoggerFactory loggerFactory = (LoggerFactory) XMLUtil.getObjectFromXMLByTagName("src/design/pattern/ch04/factory/example2/config.xml", "factory");
        Logger logger = loggerFactory.getLogger();
        logger.writeLog();
    }
}
