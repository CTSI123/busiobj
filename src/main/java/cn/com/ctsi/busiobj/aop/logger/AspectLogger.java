package cn.com.ctsi.busiobj.aop.logger;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AspectLogger {
    private static Logger logger = LoggerFactory.getLogger(AspectLogger.class);
    private String prefix;
    private int index;

    public AspectLogger(String prefix, int index) {
        this.prefix = prefix;
        this.index = index;
    }

    public void logCallingInfo(JoinPoint point) {
        this.logClassAndMethod(point);
        this.logArgs(point.getArgs());
    }

    private void logClassAndMethod(JoinPoint point) {
        Class clz = point.getTarget().getClass();
        String methodName = point.getSignature().getName();
        logger.info("[{}_{}] around [{}].[{}]", new Object[]{this.prefix, this.index, clz, methodName});
    }

    private void logArgs(Object[] args) {
        int argsLength = args == null ? 0 : args.length;
        if (argsLength > 0) {
            for(int i = 0; i < argsLength; ++i) {
                logger.info("[{}_{}] arg[{}]: {}", new Object[]{this.prefix, this.index, i, args[i]});
            }
        }

    }

    public void logResponse(Object response) {
        logger.info("[{}_{}] response: {}", new Object[]{this.prefix, this.index, response});
    }

    public void logThrow(Throwable t) {
        logger.error("[{}_{}] throw error", new Object[]{this.prefix, this.index, t});
    }
}
