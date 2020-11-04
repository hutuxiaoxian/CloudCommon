package com.zhishouwei.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 *  数据脱敏Util<br>
 *
 * @className: DataDesensitizationUtil
 * @package: com.bjblackhole.common.utils
 * @author: TR
 * @date: 2020/7/11 15:50
 */
public class DataDesensitizationUtil {
    /**
     * 手机号脱敏
     * @param mobile mobile
     * @return String
     */
    public static String mobileEncy(String mobile) {
        if (StringUtils.isNotEmpty(mobile)) {
           return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        } else {
           return "";
        }
    }
    /**
     * 邮箱脱敏
     * @param email email
     * @return String
     */
    public static String emailEncy(String email) {
        if (StringUtils.isNotEmpty(email)) {
            return email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
        } else {
            return "";
        }
    }


}
