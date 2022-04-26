package design.pattern.ch22.observer;

import java.util.ArrayList;

/**
 * “程序羊”公众号
 * 相当于ConcreteSubject
 */
public class CodeSheep extends WeChatOfficialAccount {
    
    /**
     * 订阅者/关注者/粉丝
     */
    protected ArrayList<WeChatAccount> subscribers = new ArrayList<>();
    
    /**
     * 发布新推文
     */
    @Override
    public void pushNewArticle(String article) {
        for (WeChatAccount subscriber : subscribers) {
            subscriber.receiveMessage(article);
        }
    }
    
    /**
     * 增加订阅者/关注者/粉丝
     */
    @Override
    public void addSubscriber(WeChatAccount weChatAccount) {
        subscribers.add(weChatAccount);
    }
    
    /**
     * 删除订阅者/关注者/粉丝
     */
    @Override
    public void deleteSubscriber(WeChatAccount weChatAccount) {
        subscribers.remove(weChatAccount);
    }
    
}
