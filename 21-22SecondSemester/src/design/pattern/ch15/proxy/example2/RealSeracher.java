package design.pattern.ch15.proxy.example2;

/**
 * 充当具体主题角色
 */
public class RealSeracher implements AbstractSearcher {
    @Override
    public String doSearch(String userId, String keyword) {
        System.out.println("用户" + userId + "使用关键词" + keyword + "查询商务信息");
        return "查询结果";
    }
}
