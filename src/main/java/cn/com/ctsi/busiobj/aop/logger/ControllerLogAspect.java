package cn.com.ctsi.busiobj.aop.logger;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ControllerLogAspect extends AbstractLogAspect {

    private final static Log log = LogFactory.getLog(ControllerLogAspect.class);

    public ControllerLogAspect() {
        super("ctr");
    }

    @Pointcut("execution(public *  cn.com.ctsi.busiobj.controller..*Controller.*(..))")
    public void aroundPoint() {
    }

    @Around("aroundPoint()")
    public Object aroundController(ProceedingJoinPoint point) throws Throwable {
        return this.doAround(point);
    }

}