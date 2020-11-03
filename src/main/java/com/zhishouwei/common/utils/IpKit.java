package com.zhishouwei.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;


/**
 * @author sunsl
 * @version 1.0
 * @date 2020/5/26 14:26
 */
public class IpKit {

    public static String getRealIp(HttpServletRequest request) {
        String unknown = "unknown";
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String getRealIpV2(HttpServletRequest request) {
        String accessIp = request.getHeader("x-forwarded-for");
        if (null == accessIp) {
            return request.getRemoteAddr();
        }

        return accessIp;
    }

    public static String getServerIp() {
        String localIp = null;
        try {
            InetAddress ia = InetAddress.getLocalHost();
            localIp = ia.getHostAddress();
            return localIp;
        } catch (Exception e) {

        }
        return localIp;
    }
}