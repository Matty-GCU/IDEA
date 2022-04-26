package design.pattern.ch22.observer;

/**
 * 微信公众号
 * 相当于AbstractSubject
 */
public abstract class WeChatOfficialAccount {
    
    /**
     * 发布新推文
     */
    public abstract void pushNewArticle(String article);
    
    /**
     * 增加订阅者/关注者/粉丝
     */
    public abstract void addSubscriber(WeChatAccount weChatAccount);
    
    /**
     * 删除订阅者/关注者/粉丝
     */
    public abstract void deleteSubscriber(WeChatAccount weChatAccount);
}
