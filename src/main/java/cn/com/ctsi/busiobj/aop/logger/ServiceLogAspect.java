package cn.com.ctsi.busiobj.aop.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ServiceLogAspect extends AbstractLogAspect {
    public ServiceLogAspect() {
        super("srv");
    }

    @Pointcut("execution(public * cn.com.ctsi.busiobj.service..*Service.*(..))")
    public void aroundPoint() {
    }

    @Around("aroundPoint()")
    public Object aroundController(ProceedingJoinPoint point) throws Throwable {
        return this.doAround(point);
    }
}
