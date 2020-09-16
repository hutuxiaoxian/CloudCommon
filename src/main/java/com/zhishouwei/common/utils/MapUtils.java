package com.zhishouwei.common.utils;

import org.springframework.util.ObjectUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapUtils {

    public static Map<String, String> split(String source) {
        return split(source, ",", "=");
    }

    public static Map<String, String> split(String source, String separObj, String separKey) {
        LinkedHashMap<String, String> def = new LinkedHashMap<>();
        if (!ObjectUtils.isEmpty(source) && source.length() > 0 && source.contains(separKey)) {
            source = source.trim();
            String[] objs = source.split(separObj);
            if (objs.length >= 1) {
                for (String item : objs) {
                    if (item.contains(separKey)) {
                        String[] kv = item.split(separKey);
                        if (kv.length == 2) {
                            def.put(kv[0], kv[1]);
                        }
                    }
                }
            }
         }
        return def;
    }
}
