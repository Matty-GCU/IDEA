package textbook.chapter04.dynamic.proxy.jdk;

import textbook.chapter04.dynamic.proxy.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * InvocationHandler is the interface implemented by the invocation handler of a proxy instance.
 * Each proxy instance has an associated invocation handler.
 * When a method is invoked on a proxy instance, the method invocation is encoded and dispatched to the invoke method of its invocation handler.
 * 就是说，创建了代理对象后，它要是想调用方法，可以让这个handler来做。
 */
public class JDKInvocationHandler implements InvocationHandler {

    /**
     * 被代理对象（目标类接口对象）
     */
    private Dao dao;

    /**
     * 创建代理对象（与被代理对象实现相同的接口，拥有完全相同的方法结构），建立代理对象与被代理对象的代理关系，并返回代理对象
     */
    public Object createProxy(Dao dao) {
        this.dao = dao;
        //这里课本写的是JDKDynamicProxy.class.getClassLoader()，在此处效果相同，但我觉得这样写更容易理解。
        ClassLoader classLoader = Dao.class.getClassLoader();
        Class[] interfaces = dao.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, interfaces, this);
    }

    /**
     * Processes a method invocation on a proxy instance and returns the result.
     * This method will be invoked on an invocation handler when a method is invoked on a proxy instance that it is associated with.
     * 所有动态代理类的方法调用都交给这个方法处理
     * @param proxy 代理对象
     * @param method 上述对象的某个方法
     * @param args 上述方法的所有参数
     * @return 上述方法的返回值（代理结果）
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //创建一个切面
        MyAspect myAspect = new MyAspect();
        //前增强
        myAspect.check();
        myAspect.except();
        //使用被代理对象调用方法，并传入方法参数，获取方法返回值
        Object result = method.invoke(dao, args);
        //后增强
        myAspect.log();
        myAspect.monitor();
        return result;
    }
}