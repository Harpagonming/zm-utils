package com.zhenming.utils;

import com.zhenming.enums.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 提供时间格式互相转换功能，包含LocalTime、LocaDlDate、LocalDateTime、Date、String以及Long类型
 */
public class DateTimeUtils {
    private static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    public static String localTime2String(LocalTime localTime) {
        assert localTime != null;
        return localTime2String(localTime, DateTimeFormat.STANDARD_TIME_FORMAT);
    }

    public static String localTime2String(LocalTime localTime, DateTimeFormat format) {
        return localTime.format(format.getFormatter());
    }

    public static Date localDate2Date(LocalDate localDate) {
        return localDate2Date(localDate, DEFAULT_ZONE_ID);
    }

    public static Date localDate2Date(LocalDate localDate, ZoneId zoneId) {
        return Date.from(localDate.atTime(0, 0, 0).atZone(zoneId).toInstant());
    }

    public static String localDate2String(LocalDate localDate) {
        return localDate2String(localDate, DateTimeFormat.STANDARD_DATE_FORMAT);
    }

    public static String localDate2String(LocalDate localDate, DateTimeFormat format) {
        return localDate.format(format.getFormatter());
    }

    public static long localDate2Long(LocalDate localDate) {
        return localDate2Long(localDate, DEFAULT_ZONE_ID);
    }

    public static long localDate2Long(LocalDate localDate, ZoneId zoneId) {
        return localDate.atTime(0, 0, 0).atZone(zoneId).toInstant().toEpochMilli();
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return localDateTime2Date(localDateTime, DEFAULT_ZONE_ID);
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime, ZoneId zoneId) {
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    public static String localDateTime2String(LocalDateTime localDateTime) {
        return localDateTime2String(localDateTime, DateTimeFormat.STANDARD_DATETIME_FORMAT);
    }

    public static String localDateTime2String(LocalDateTime localDateTime, DateTimeFormat format) {
        return localDateTime.format(format.getFormatter());
    }

    public static long localDateTime2Long(LocalDateTime localDateTime) {
        return localDateTime2Long(localDateTime, DEFAULT_ZONE_ID);
    }

    public static long localDateTime2Long(LocalDateTime localDateTime, ZoneId zoneId) {
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    public static LocalDateTime long2LocalDateTIme(long timestamp) {
        return long2LocalDateTIme(timestamp, DEFAULT_ZONE_ID);
    }

    public static LocalDateTime long2LocalDateTIme(long timestamp, ZoneId zoneId) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), zoneId);
    }

    public static LocalDate long2LocalDate(long timestamp) {
        return long2LocalDate(timestamp, DEFAULT_ZONE_ID);
    }

    public static LocalDate long2LocalDate(long timestamp, ZoneId zoneId) {
        return long2LocalDateTIme(timestamp, zoneId).toLocalDate();
    }

    public static LocalTime long2LocalTime(long timestamp) {
        return long2LocalTime(timestamp, DEFAULT_ZONE_ID);
    }

    public static LocalTime long2LocalTime(long timestamp, ZoneId zoneId) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), zoneId).toLocalTime();
    }

    public static Date long2Date(long timestamp) {
        return new Date(timestamp);
    }

    public static String long2String(long timestamp, DateTimeFormat format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format.getPattern());
        return sdf.format(new Date(timestamp));
    }

    public static LocalDateTime string2LocalDateTime(String str, DateTimeFormat format) {
        return LocalDateTime.parse(str, format.getFormatter());
    }

    public static LocalDate string2LocalDate(String str, DateTimeFormat format) {
        return LocalDate.parse(str, format.getFormatter());
    }

    public static LocalTime string2LocalTime(String str, DateTimeFormat format) {
        return LocalTime.parse(str, format.getFormatter());
    }

    public static Date string2Date(String str, DateTimeFormat format) {
        return string2Date(str, format, DEFAULT_ZONE_ID);
    }

    public static Date string2Date(String str, DateTimeFormat format, ZoneId zoneId) {
        return Date.from(LocalDateTime.parse(str, format.getFormatter()).atZone(zoneId).toInstant());
    }

    public static long string2Long(String str, DateTimeFormat format) {
        return string2Long(str, format, DEFAULT_ZONE_ID);
    }

    public static long string2Long(String str, DateTimeFormat format, ZoneId zoneId) {
        return LocalDateTime.parse(str, format.getFormatter()).atZone(zoneId).toInstant().toEpochMilli();
    }

    public static LocalDateTime date2LocalDateTime(Date date) {
        return date2LocalDateTime(date, DEFAULT_ZONE_ID);
    }

    public static LocalDateTime date2LocalDateTime(Date date, ZoneId zoneId) {
        return date.toInstant().atZone(zoneId).toLocalDateTime();
    }

    public static LocalDate date2LocalDate(Date date) {
        return date2LocalDate(date, DEFAULT_ZONE_ID);
    }

    public static LocalDate date2LocalDate(Date date, ZoneId zoneId) {
        return date.toInstant().atZone(zoneId).toLocalDate();
    }

    public static LocalTime date2LocalTime(Date date) {
        return date2LocalTime(date, DEFAULT_ZONE_ID);
    }

    public static LocalTime date2LocalTime(Date date, ZoneId zoneId) {
        return date.toInstant().atZone(zoneId).toLocalTime();
    }

    public static String date2String(Date date) {
        return date2String(date, DateTimeFormat.STANDARD_DATETIME_FORMAT);
    }

    public static String date2String(Date date, DateTimeFormat format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format.getPattern());
        return sdf.format(date);
    }

    public static long getDuration(Date start, Date end, ChronoUnit unit) {
        LocalDate startDate = start.toInstant().atZone(DEFAULT_ZONE_ID).toLocalDate();
        LocalDate endDate = end.toInstant().atZone(DEFAULT_ZONE_ID).toLocalDate();
        return startDate.until(endDate, unit);
    }

    public static long getDuration(Date start, ChronoUnit unit) {
        return getDuration(start, new Date(), unit);
    }
}
