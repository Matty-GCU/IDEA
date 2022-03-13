package textbook.chapter04.dynamic.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import textbook.chapter04.dynamic.proxy.MyAspect;

import java.lang.reflect.Method;

public class CglibInterceptor implements MethodInterceptor {

    /**
     * @param target 目标对象，即需要增强的对象
     * @return 目标对象的CGLIB代理对象
     */
    public Object createProxy(Object target) {
        //创建一个增强类对象
        Enhancer enhancer = new Enhancer();
        //确定其父类，即指定需要增强的类
        enhancer.setSuperclass(target.getClass());
        //确定当前对象为方法拦截器
        enhancer.setCallback(this);
        //返回最终创建的代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        MyAspect myAspect = new MyAspect();
        myAspect.check();
        myAspect.except();
        //因为CGLIB代理对象是继承了被代理对象（而不是实现同一接口），所以调用的是父方法
        Object result = methodProxy.invokeSuper(proxy, args);
        myAspect.log();
        myAspect.monitor();
        return result;
    }
}
