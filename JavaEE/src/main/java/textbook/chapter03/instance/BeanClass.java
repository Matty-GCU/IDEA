package textbook.chapter03.instance;

public class BeanClass {

    public String message;

    public BeanClass() {
        message = "使用构造方法实例化";
    }

    public BeanClass(String message) {
        this.message = message;
    }
}
