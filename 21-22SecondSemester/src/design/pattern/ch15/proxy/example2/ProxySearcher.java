package design.pattern.ch15.proxy.example2;

public class ProxySearcher implements AbstractSearcher {
    private RealSeracher realSeracher = new RealSeracher();
    private AccessValidator accessValidator;
    private Logger logger;
    
    
    @Override
    public String doSearch(String userId, String keyword) {
        if(this.validate(userId)) {
            String result = realSeracher.doSearch(userId, keyword);
            this.log(userId);
            return result;
        } else {
            return null;
        }
    }
    
    public boolean validate(String userId) {
        accessValidator = new AccessValidator();
        return accessValidator.validate(userId);
    }
    
    public void log(String userId) {
        logger = new Logger();
        logger.log(userId);
    }
}
