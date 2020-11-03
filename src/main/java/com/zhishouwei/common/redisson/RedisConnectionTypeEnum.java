package com.zhishouwei.common.redisson;

/**
 *Redis连接方式
 *          包含:standalone-单节点部署方式
 *              sentinel-哨兵部署方式
 *              cluster-集群方式
 *              masterslave-主从部署方式
 * @className: RedisConnectionTypeEnum
 * @package: com.bjblackhole.common.enums
 * @author: 曾维录
 * @date: 2020/7/7 13:16
 */
public enum RedisConnectionTypeEnum {
    TANDALONE("standalone", "单节点部署方式"),
    SENTINEL("sentinel", "哨兵部署方式"),
    CLUSTER("cluster", "集群方式"),

    MASTERSLAVE("masterslave", "主从部署方式");

    private String code;
    private String message;

     RedisConnectionTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}