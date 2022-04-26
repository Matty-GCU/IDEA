package design.pattern.ch22.observer;

/**
 * “Matty”个人号
 * 相当于Observer
 */
public class Matty extends WeChatAccount {
    
    /**
     * 接收信息（新文章）
     */
    @Override
    public void receiveMessage(String article) {
        System.out.println("Matty收到新文章：" + article);
    }
    
    /**
     * 关注/订阅公众号
     */
    @Override
    public void subscribe(WeChatOfficialAccount weChatOfficialAccount) {
        weChatOfficialAccount.addSubscriber(this);
    }
    
    /**
     * 取消关注/取消订阅公众号
     */
    @Override
    public void unsubscribe(WeChatOfficialAccount weChatOfficialAccount) {
        weChatOfficialAccount.deleteSubscriber(this);
    }
}
