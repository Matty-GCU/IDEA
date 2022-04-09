package design.pattern.ch15.proxy.example1;

/**
 * 真实主题角色
 */
public class RealSubject extends AbstractSubject {
    @Override
    public void request() {
        System.out.println("业务方法的具体实现代码");
    }
}
