package com.zhishouwei.common.model.service.impl;

import com.zhishouwei.common.model.service.RedissonConfigService;
import com.zhishouwei.common.redisson.RedissonConfig;
import lombok.extern.slf4j.Slf4j;
import org.redisson.config.Config;
import org.springframework.util.StringUtils;

/**
 * 单机部署 Redisson配置
 *
 * @className: StandaloneConfigImpl
 * @package: com.bjblackhole.common.service.impl
 * @author: 曾维录
 * @date: 2020/7/7 13:02
 */
@Slf4j
public class StandaloneConfigImpl  implements RedissonConfigService {

    @Override
    public Config createRedissonConfig(RedissonConfig redissonConfig) {
        Config config = new Config();
        try {
            String address = redissonConfig.getAddress();
            String password = redissonConfig.getPassword();
            int database = redissonConfig.getDatabase();
            String redisAddr = REDIS_CONNECTION_PREFIX + address;
            config.useSingleServer().setAddress(redisAddr);
            config.useSingleServer().setDatabase(database);
            //密码可以为空
            if (!StringUtils.isEmpty(password)) {
                config.useSingleServer().setPassword(password);
            }
            log.info("初始化[单机部署]方式Config,redisAddress:" + address);
        } catch (Exception e) {
            log.error("单机部署 Redisson init error", e);
        }
        return config;
    }

}
