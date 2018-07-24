package cn.com.ctsi.busiobj.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    public LogUtil() {
    }

    private static Logger getLogger(Class clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    public static void logError(String error, Class<?> clazz) {
        getLogger(clazz).error(error);
    }

    public static void logError(String error, Class<?> clazz, Exception ex) {
        getLogger(clazz).error(error, ex);
    }

    public static void logInfo(String info, String prefix, Class<?> clazz) {
        getLogger(clazz).info("[{}] {}", prefix, info);
    }

    public static void debug(Class clazz, String msg) {
        getLogger(clazz).debug(msg);
    }

    public static void debug(Class clazz, String msg, Object... args) {
        getLogger(clazz).debug(msg, args);
    }

    public static void info(Class clazz, String msg) {
        getLogger(clazz).info(msg);
    }

    public static void info(Class clazz, String msg, Object... args) {
        getLogger(clazz).info(msg, args);
    }

    public static void error(Class clazz, String msg) {
        getLogger(clazz).error(msg);
    }

    public static void error(Class clazz, String msg, Object... args) {
        getLogger(clazz).error(msg, args);
    }

    public static void error(Class clazz, String msg, Throwable t) {
        getLogger(clazz).error(msg, t);
    }

    public static void LogInfo(String info, String prefix, Class<?> clazz) {
        getLogger(clazz).info("[{}] {}", prefix, info);
    }
}
