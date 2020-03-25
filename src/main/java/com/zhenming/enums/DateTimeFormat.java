package com.zhenming.enums;

import java.time.format.DateTimeFormatter;

public enum DateTimeFormat {
    STANDARD_DATETIME_FORMAT(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"),
    STANDARD_TIME_FORMAT(DateTimeFormatter.ofPattern("HH:mm:ss"), "HH:mm:ss"),
    STANDARD_DATE_FORMAT(DateTimeFormatter.ofPattern("yyyy-MM-dd"), "yyyy-MM-dd"),
    STANDARD_WEEK_FORMAT(DateTimeFormatter.ofPattern("YYYY-ww"), "YYYY-ww"),
    STANDARD_MONTH_FORMAT(DateTimeFormatter.ofPattern("yyyy-MM"), "yyyy-MM");

    private DateTimeFormatter formatter;

    private String pattern;

    DateTimeFormat(DateTimeFormatter formatter, String pattern) {
        this.formatter = formatter;
        this.pattern = pattern;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public String getPattern() {
        return pattern;
    }
}
