package cn.com.ctsi.busiobj.util;

import java.math.BigDecimal;
import java.util.Collection;

public class BaseBean {
    private static final int PARAM_INTEGER_EMPTY = -1;
    private static final float PARAM_INTEGER_EMPTY_FLOAT = 0.0F;
    private static final long PARAM_INTEGER_EMPTY_LONG = 0L;

    public BaseBean() {
    }

    public static boolean isNotEmpty(Integer sTemp) {
        return sTemp != null;
    }

    public static boolean isEmpty(Integer sTemp) {
        return sTemp == null;
    }

    public static boolean isEmpty(Integer[] sTemp) {
        return sTemp == null;
    }

    public static boolean isNotEmpty(BigDecimal sTemp) {
        return sTemp != null;
    }

    public static boolean isEmpty(BigDecimal sTemp) {
        return sTemp == null;
    }

    public static boolean isNotEmpty(Long sTemp) {
        return sTemp != null && !sTemp.equals(0L);
    }

    public static boolean isEmpty(Long sTemp) {
        return sTemp == null || sTemp.equals(0L);
    }

    public static boolean isNotEmpty(Float sTemp) {
        return sTemp != null && !sTemp.equals(0.0F);
    }

    public static boolean isEmpty(Float sTemp) {
        return sTemp == null || sTemp.equals(0.0F);
    }

    public static boolean isNotEmpty(String sTemp) {
        return sTemp != null && !sTemp.trim().equals("");
    }

    public static boolean isEmpty(String sTemp) {
        return sTemp == null || sTemp.trim().equals("");
    }

    public static boolean isEmpty(Collection col) {
        return col == null || col.size() == 0;
    }

    public static boolean isNotEmpty(Collection col) {
        return col != null && col.size() != 0;
    }

    public static Double ToDouble(Object source) {
        if (source == null) {
            return 0.0D;
        } else if (source instanceof Float) {
            Float temp = (Float)source;
            return temp.doubleValue();
        } else if (source instanceof Integer) {
            Integer temp = (Integer)source;
            return temp.doubleValue();
        } else {
            return source instanceof Double ? (Double)source : 0.0D;
        }
    }

    public static boolean isNotIntNegative(Integer number) {
        return number > 0 && number <= 2147483647;
    }

    public static boolean isNotStringSize(String str, Integer size) {
        return str.length() > size;
    }

    public static boolean isNotTypeSize(Integer type, Integer min, Integer max) {
        return type > max || type < min;
    }

    public static boolean isNotStringSize(String mdn, Integer one, Integer two) {
        return mdn.length() != one && mdn.length() != two;
    }
}
