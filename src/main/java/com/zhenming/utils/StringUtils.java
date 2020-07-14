package com.zhenming.utils;

public class StringUtils {
    private StringUtils() {
    }

    private static final String HEXES = "0123456789abcdef";

    /**
     * 将二进制数组转为16进制字符串
     *
     * @param raw 需要转换的二进制数组
     * @return 输出的16进制字符串
     */
    public static String getHex(byte[] raw) {
        if (raw == null) {
            return null;
        }
        final StringBuilder hex = new StringBuilder(2 * raw.length);
        for (final byte b : raw) {
            hex.append(HEXES.charAt((b & 0xF0) >> 4)).append(HEXES.charAt((b & 0x0F)));
        }
        return hex.toString();
    }
}
