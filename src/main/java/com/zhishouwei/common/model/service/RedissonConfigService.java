package com.zhishouwei.common.model.service;

import com.zhishouwei.common.redisson.RedissonConfig;
import org.redisson.config.Config;

/**
 * Redisson 配置构建接口<br>
 *
 * @className: RedissonConfigService
 * @package: com.bjblackhole.common
 * @author: 曾维录
 * @date: 2020/7/7 11:58
 */

public interface RedissonConfigService {
    //路径前缀
    String REDIS_CONNECTION_PREFIX = "redis://";
    /**
     * 根据不同的Redis配置策略创建对应的Config
     * @param redissonConfig redissonConfig
     * @return Config
     */
    Config createRedissonConfig(RedissonConfig redissonConfig);
}
