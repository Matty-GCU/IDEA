package p20;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LogAspect implements MethodBeforeAdvice, AfterReturningAdvice {
    /**
     * Callback before a given method is invoked.
     * @param method the method being invoked
     * @param args the arguments to the method
     * @param target the target of the method invocation. May be {@code null}.
     * @throws Throwable if this object wishes to abort the call.
     * Any exception thrown will be returned to the caller if it's
     * allowed by the method signature. Otherwise the exception
     * will be wrapped as a runtime exception.
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("前置增强");
        System.out.println("被代理对象" + target.getClass().getSimpleName() + "即将调用" + method.getName() + "方法，参数是" + args);
    }
    
    /**
     * Callback after a given method successfully returned.
     * @param returnValue the value returned by the method, if any
     * @param method the method being invoked
     * @param args the arguments to the method
     * @param target the target of the method invocation. May be {@code null}.
     * @throws Throwable if this object wishes to abort the call.
     * Any exception thrown will be returned to the caller if it's
     * allowed by the method signature. Otherwise the exception
     * will be wrapped as a runtime exception.
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("被代理对象" + target.getClass().getSimpleName() + "已经调用过" + method.getName() + "方法，参数是" + args + "，返回值是" + returnValue);
        System.out.println("后置增强");
    }
}
