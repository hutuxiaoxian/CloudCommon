package com.zhishouwei.common.redisson;

/**
 * @author sunsl
 * @version 1.0
 * @date 2020/6/15 11:21
 */
public class RedisConstants {

    /**
     * 增量 1 long
     */
    public static final long LONG_COUNT = 1L;

    /**
     * 增量 1 int
     */
    public static final int INT_COUNT = 1;

    /**
     * 默认开始
     */
    public static final int LIST_DEFAULT_START = 0;


    /**
     * 默认结束 -1 标识全部列表
     */
    public static final int LIST_DEFAULT_END = -1;

    /**
     * 永久时间
     */
    public static final int PERMANENT = -1;

    /**
     * 一分钟 （秒）
     */
    public static final int ONE_MINUTE = 60;

    /**
     * 5分钟 （秒）
     */
    public static final int FIVE_MINUTE = 300;

    /**
     * 10分钟 （秒）
     */
    public static final int TEN_MINUTE = 600;

    /**
     * 1小时（秒）
     */
    public static final int ONE_HOUR = 3600;

    /**
     * 半天 12小时
     */
    public static final int HALF_DAY = 43200;

    /**
     * 1小时（秒）
     */
    public static final int ONE_WEEK = 604800;

}
