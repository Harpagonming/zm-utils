package com.zhenming.enums;

public enum MimeType {
    EXCEL("application/msexcel"),
    PNG("image/png"),
    JPG("image/jpeg");

    private String value;

    MimeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
