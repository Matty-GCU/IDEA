package textbook.chapter04.aspectj.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类，在此类中编写各种类型的通知
 */
public class MyAspect03 {
    
    /**
     * 前置通知
     */
    public void before(JoinPoint joinPoint) {
        System.out.print("前置通知：模拟权限控制");
        System.out.print("，目标类对象：" + joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("，被增强处理的方法：" + joinPoint.getSignature().getName());
    }
    
    /**
     * 后置返回通知
     */
    public void afterReturning(JoinPoint joinPoint) {
        System.out.print("后置返回通知：模拟删除临时文件");
        System.out.println("，被增强处理的方法：" + joinPoint.getSignature().getName());
    }
    
    /**
     * 环绕通知
     */
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("环绕开始：执行目标方法前，模拟开启事务；");
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕结束：执行目标方法后，模拟关闭事务。");
        return result;
    }
    
    /**
     * 异常通知
     */
    public void except(Throwable throwable) {
        System.out.println("异常通知：程序执行异常" + throwable.getMessage());
    }
    
    /**
     * 后置（最终）通知
     */
    public void after() {
        System.out.println("后置最终通知：模拟释放资源");
    }
}
