package textbook.chapter03.lifecycle;

public class BeanLife {

    public BeanLife() {
        System.out.println("调用无参构造方法");
    }

    public void initMyself() {
        System.out.println(this.getClass().getName() + "执行自定义的初始化方法");
    }
    public void destroyMyself() {
        System.out.println(this.getClass().getName() + "执行自定义的销毁方法");
    }
}
