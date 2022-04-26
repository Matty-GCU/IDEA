package design.pattern.ch22.observer;

public class Test {
    public static void main(String[] args) {
        WeChatOfficialAccount codeSheep = new CodeSheep();
        WeChatAccount matty = new Matty();
        matty.subscribe(codeSheep);
        codeSheep.pushNewArticle("Code的第一篇新文章");
    }
}
