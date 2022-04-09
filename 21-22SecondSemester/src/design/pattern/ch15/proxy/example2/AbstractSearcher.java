package design.pattern.ch15.proxy.example2;

/**
 * 充当抽象主题角色
 */
public interface AbstractSearcher {
    String doSearch(String userId, String keyword);
}
