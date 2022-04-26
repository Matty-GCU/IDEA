package design.pattern.ch22.observer;

/**
 * 微信号（个人账户）
 * 相当于AbstractObserver
 */
public abstract class WeChatAccount {
    
    /**
     * 接收信息（新文章）
     */
    public abstract void receiveMessage(String article);
    
    /**
     * 关注/订阅公众号
     */
    public abstract void subscribe(WeChatOfficialAccount weChatOfficialAccount);
    
    /**
     * 取消关注/取消订阅公众号
     */
    public abstract void unsubscribe(WeChatOfficialAccount weChatOfficialAccount);
}
