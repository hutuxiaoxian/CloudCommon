package com.zhishouwei.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @description: 时间工具类
 * @author： zhus
 * @version: 1.0
 * @date: 2020/7/3 13:57
 */
public class DateUtil {

    /**
     * 获取当前时间"yyyy-MM-dd HH:mm:ss"
     *
     * @return String
     */
    public static String now() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("+8"));
        String dateTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
        return dateTime;
    }

    /**
     * 获取当前时间"yyyy-MM-dd HH:mm:ss"
     * @param time 时间
     * @return String
     */
    public static String format(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.format(sdf.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前时间"yyyy-MM-dd HH:mm:ss"
     * @param time 时间戳
     * @return String
     */
    public static String format(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(time));
    }

    /**
     * 获取当前时间"yyyy-MM-dd HH:mm:ss"
     * @param time 时间戳
     * @param pattern 时间格式
     * @return String
     */
    public static String format(Long time, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date(time));
    }
}
