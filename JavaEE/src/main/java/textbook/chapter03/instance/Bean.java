package textbook.chapter03.instance;

public class Bean {

    public String message;

    public Bean() {
        message = "使用构造方法实例化";
    }

    public Bean(String message) {
        this.message = message;
    }
}
