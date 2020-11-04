package com.zhishouwei.common.redisson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunsl
 * @version 1.0
 * @date 2020/4/8 17:52
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public RedisUtil redisUtil() {
        return new RedisUtil();
    }
    /**
     * redis key 生成策略
     *
     * @return key
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getCanonicalName()).append("_");
            sb.append(method.getName()).append("_");
            for (Object obj : params) {
                sb.append(obj).append("_");
            }
            return sb.toString();
        };
    }

    /**
     * redis 序列化
     *
     * @param factory 工厂
     * @return RedisTemplate
     */
    @Bean(name = "redisTemplate")
    @Primary
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value也采用String的序列化方式
        template.setValueSerializer(stringRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    /**
     * 管理 缓存失效时间
     *
     * @param redisConnectionFactory 工厂
     * @return CacheManager
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
                // 默认策略，未配置的 key 会使用这个
                this.getRedisCacheConfigurationWithTtl(RedisConstants.FIVE_MINUTE),
                // 指定 key 策略
                this.getRedisCacheConfigurationMap()
        );
    }

    /**
     * 自定缓存失效时间策略
     *
     * @return Map
     */
    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put("MINUTE_10", this.getRedisCacheConfigurationWithTtl(RedisConstants.TEN_MINUTE));
        redisCacheConfigurationMap.put("HOUR_1", this.getRedisCacheConfigurationWithTtl(RedisConstants.ONE_HOUR));
        redisCacheConfigurationMap.put("WEEK_1", this.getRedisCacheConfigurationWithTtl(RedisConstants.ONE_WEEK));
        redisCacheConfigurationMap.put("HOUR_12", this.getRedisCacheConfigurationWithTtl(RedisConstants.HALF_DAY));
        redisCacheConfigurationMap.put("PERMANENT", this.getRedisCacheConfigurationWithTtl(RedisConstants.PERMANENT));
        return redisCacheConfigurationMap;
    }

    /**
     * 设置缓存时效
     *
     * @param seconds 秒
     * @return RedisCacheConfiguration
     */
    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer)
        ).entryTtl(Duration.ofSeconds(seconds));

        return redisCacheConfiguration;
    }
}
