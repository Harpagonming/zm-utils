package com.zhenming.enums;

public enum DeleteFlag {
    UN_DELETED("0"),
    DELETED("1");

    private String value;

    DeleteFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
