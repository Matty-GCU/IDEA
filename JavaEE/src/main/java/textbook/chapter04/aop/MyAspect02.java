package textbook.chapter04.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect02 implements MethodInterceptor {
    
    /**
     * Implement this method to perform extra treatments before and
     * after the invocation.
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        check();
        except();
        Object result = invocation.proceed();
        log();
        monitor();
        return result;
    }
    
    public void check() {
        System.out.println("模拟权限控制");
    }
    public void except() {
        System.out.println("模拟异常处理");
    }
    public void log() {
        System.out.println("模拟日志记录");
    }
    public void monitor() {
        System.out.println("模拟性能监测");
    }
}
