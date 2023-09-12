package com.zhsq.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
    /**
     * 将 LocalDateTime 对象转换为 Date 对象
     *
     * @param localDateTime LocalDateTime 对象
     * @return Date 对象
     */
    public static Date toDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault(); // 获取当前时区
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }
    /**
     * 将 Date 对象转换为 LocalDateTime 对象
     *
     * @param date Date 对象
     * @return LocalDateTime 对象
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
