package com.zhishouwei.common.model.service.impl;

import com.zhishouwei.common.model.service.RedissonConfigService;
import com.zhishouwei.common.redisson.RedissonConfig;
import lombok.extern.slf4j.Slf4j;
import org.redisson.config.Config;
import org.springframework.util.StringUtils;

/**
 *集群方式 Redisson部署
 *地址格式：
 *cluster方式至少6个节点(3主3从，3主做sharding，3从用来保证主宕机后可以高可用)
 * 格式为: 127.0.0.1:6379,127.0.0.1:6380,127.0.0.1:6381,127.0.0.1:6382,127.0.0.1:6383,127.0.0.1:6384
 * @className: ClusterConfigImpl
 * @package: com.bjblackhole.common.service
 * @author: 曾维录
 * @date: 2020/7/7 12:51
 */
@Slf4j
public class ClusterConfigImpl implements RedissonConfigService {

    @Override
    public Config createRedissonConfig(RedissonConfig redissonConfig) {
        Config config = new Config();
        try {
            String address = redissonConfig.getAddress();
            String password = redissonConfig.getPassword();
            String[] addrTokens = address.split(",");
            //设置cluster节点的服务IP和端口
            for (int i = 0; i < addrTokens.length; i++) {
                config.useClusterServers()
                        .addNodeAddress(REDIS_CONNECTION_PREFIX + addrTokens[i]);
                if (!StringUtils.isEmpty(password)) {
                    config.useClusterServers().setPassword(password);
                }
            }
            log.info("初始化[集群部署]方式Config,redisAddress:" + address);
        } catch (Exception e) {
            log.error("集群部署 Redisson init error", e);
            e.printStackTrace();
        }
        return config;
    }
}

