package design.pattern.ch15.proxy.example2;

public class Client {
    public static void main(String[] args) {
        AbstractSearcher searcher = new ProxySearcher();
        searcher.doSearch("合法用户的ID", "apple");
    }
}
