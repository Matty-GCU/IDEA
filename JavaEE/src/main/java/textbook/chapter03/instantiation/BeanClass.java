package textbook.chapter03.instantiation;

public class BeanClass {

    public String message;

    public BeanClass() {
        message = "Spring容器调用无参构造方法来实例化Bean";
    }

    public BeanClass(String message) {
        this.message = message;
    }
}
