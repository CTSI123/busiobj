package cn.com.ctsi.busiobj.aop.logger;

import org.aspectj.lang.ProceedingJoinPoint;

public abstract class AbstractLogAspect {
    private AspectLoggerFactory loggerFactory;

    public AbstractLogAspect(String prefix) {
        this.loggerFactory = new AspectLoggerFactory(prefix);
    }

    protected Object doAround(ProceedingJoinPoint point) throws Throwable {
        AspectLogger logger = this.loggerFactory.getForNewAround();
        Object response = null;
        Throwable throwable = null;

        try {
            this.prefixHandle(logger, point);
            response = point.proceed();
        } catch (Throwable var6) {
            throwable = var6;
        }

        return this.suffixHandle(logger, response, throwable);
    }

    private void prefixHandle(AspectLogger logger, ProceedingJoinPoint point) throws Throwable {
        logger.logCallingInfo(point);
    }

    private Object suffixHandle(AspectLogger logger, Object response, Throwable throwable) throws Throwable {
        if (throwable != null) {
            logger.logThrow(throwable);
            throw throwable;
        } else {
            logger.logResponse(response);
            return response;
        }
    }
}
