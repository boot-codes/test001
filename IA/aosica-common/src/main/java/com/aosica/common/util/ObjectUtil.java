package com.aosica.common.util;

import java.util.Collection;

/**
 * @PackgeName com.aosica.common.util
 * @ClassName ObjectUtil.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/10/14 15:38
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/10/14$ 15:38$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public final class ObjectUtil {


    private ObjectUtil() {
    }


    public static <T> T checkNotNull(T arg, String text) {
        if (arg == null ) {
            throw new NullPointerException(text);
        }
        return arg;
    }

    public static String checkNotEmpty(String value, String text) {
        if (value == null || value.length() ==0) {
            throw new NullPointerException(text);
        }
        return text ;
    }


    public static int checkPositive(int i, String name) {
        if (i <= 0) {
            throw new IllegalArgumentException(name + ": " + i + " (expected: > 0)");
        }
        return i;
    }


    public static long checkPositive(long i, String name) {
        if (i <= 0) {
            throw new IllegalArgumentException(name + ": " + i + " (expected: > 0)");
        }
        return i;
    }

    public static String checkLong(long i, String name) {
        if (i <= 0) {
            throw new IllegalArgumentException(name + ": " + i + " (expected: > 0)");
        }
        return name ;
    }


    public static int checkPositiveOrZero(int i, String name) {
        if (i < 0) {
            throw new IllegalArgumentException(name + ": " + i + " (expected: >= 0)");
        }
        return i;
    }


    public static long checkPositiveOrZero(long i, String name) {
        if (i < 0) {
            throw new IllegalArgumentException(name + ": " + i + " (expected: >= 0)");
        }
        return i;
    }


    public static <T> T[] checkNonEmpty(T[] array, String name) {
        checkNotNull(array, name);
        checkPositive(array.length, name + ".length");
        return array;
    }


    public static <T extends Collection<?>> T checkNonEmpty(T collection, String name) {
        checkNotNull(collection, name);
        checkPositive(collection.size(), name + ".size");
        return collection;
    }


    public static int intValue(Integer wrapper, int defaultValue) {
        return wrapper != null ? wrapper : defaultValue;
    }


    public static long longValue(Long wrapper, long defaultValue) {
        return wrapper != null ? wrapper : defaultValue;
    }
}
