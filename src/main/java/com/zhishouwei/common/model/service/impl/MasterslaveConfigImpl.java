package com.zhishouwei.common.model.service.impl;

import com.zhishouwei.common.model.service.RedissonConfigService;
import com.zhishouwei.common.redisson.RedissonConfig;
import lombok.extern.slf4j.Slf4j;
import org.redisson.config.Config;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 主从部署Redisson配置
 * 连接方式:  主节点,子节点,子节点
 * 格式为:  127.0.0.1:6379,127.0.0.1:6380,127.0.0.1:6381
 *
 * @className: MasterslaveConfigImpl
 * @package: com.bjblackhole.common.service.impl
 * @author: TR
 * @date: 2020/7/7 12:59
 */
@Slf4j
public class MasterslaveConfigImpl implements RedissonConfigService {

    @Override
    public Config createRedissonConfig(RedissonConfig redissonConfig) {
        Config config = new Config();
        try {
            String address = redissonConfig.getAddress();
            String password = redissonConfig.getPassword();
            int database = redissonConfig.getDatabase();
            String[] addrTokens = address.split(",");
            String masterNodeAddr = addrTokens[0];
            //设置主节点ip
            config.useMasterSlaveServers().setMasterAddress(masterNodeAddr);
            if (!StringUtils.isEmpty(password)) {
                config.useMasterSlaveServers().setPassword(password);
            }
            config.useMasterSlaveServers().setDatabase(database);
            //设置从节点，移除第一个节点，默认第一个为主节点
            List<String> slaveList = new ArrayList<>();
            for (String addrToken : addrTokens) {
                slaveList.add(REDIS_CONNECTION_PREFIX + addrToken);
            }
            slaveList.remove(0);

            config.useMasterSlaveServers().addSlaveAddress((String[]) slaveList.toArray());
            log.info("初始化[主从部署]方式Config,redisAddress:" + address);
        } catch (Exception e) {
            log.error("主从部署 Redisson init error", e);
            e.printStackTrace();
        }
        return config;
    }
}
