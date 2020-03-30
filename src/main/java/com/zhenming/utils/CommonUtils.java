package com.zhenming.utils;

import java.util.UUID;

public class CommonUtils {
    /**
     * 生成一个小写无“-”的UUID
     *
     * @return String UUID
     */
    public static String generateLowerUUID() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }

    /**
     * 生成一个大写无“-”的UUID
     *
     * @return String UUID
     */
    public static String generateUpperUID() {
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }
}
