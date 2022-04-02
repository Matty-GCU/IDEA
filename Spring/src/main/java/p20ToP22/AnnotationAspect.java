package p20ToP22;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationAspect {
    
    @Before("execution(* p20ToP22.ServiceP20Impl.*(..))")
    public void before() {
        System.out.println("前置增强");
    }
    
    @After("execution(* p20ToP22.ServiceP20Impl.*(..))")
    public void after() {
        System.out.println("后置增强");
    }
    
    @Around("execution(* p20ToP22.ServiceP20Impl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("signature: " + signature);
        System.out.println("环绕前");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕后");
    }
}
