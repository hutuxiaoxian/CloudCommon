package com.zhishouwei.common.redisson;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * redisson 自动配置 <br>
 *
 * @className: RedissonAutoConfiguration
 * @package: com.bjblackhole.common.config
 * @author: 曾维录
 * @date: 2020/7/7 10:32
 */
@Configuration
@ConditionalOnClass(Redisson.class)
@EnableConfigurationProperties(RedissonConfig.class)
@Slf4j
public class RedissonAutoConfiguration {
    /**
     *
     * @param redissonConfig redissonConfig
     * @return RedissonManager
     */
    @Bean
//    @ConditionalOnMissingBean
    @Order(value = 1)
    public RedissonManager redissonManager(RedissonConfig redissonConfig) {
        RedissonManager redissonManager =
                new RedissonManager(redissonConfig);
        log.info("[RedissonManager]组装完毕,当前连接方式: {}"
                + ",连接地址: {}", redissonConfig.getType(), redissonConfig.getAddress());
        return redissonManager;
    }

    /**
     *
     * @param redissonManager redissonManager
     * @return RedissonLockUtil
     */
    @Bean
//    @ConditionalOnMissingBean
    @Order(value = 2)
    public RedissonLockUtil redissonLockUtil(RedissonManager redissonManager) {
        RedissonLockUtil    redissonLock = new RedissonLockUtil(redissonManager);
        log.info("[RedissonLock]组装完毕");
        return redissonLock;
    }
}
