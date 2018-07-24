package cn.com.ctsi.busiobj.aop.logger;

import java.util.concurrent.atomic.AtomicInteger;

public class AspectLoggerFactory {
    private AtomicInteger sequence = new AtomicInteger();
    private String prefix;

    public AspectLoggerFactory(String prefix) {
        this.prefix = prefix;
    }

    public AspectLogger getForNewAround() {
        return new AspectLogger(this.prefix, this.sequence.getAndIncrement());
    }
}
