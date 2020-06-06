package com.javalow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Arrays;

/**
 * @description:
 * @author: huweixing
 * @ClassName: RedisConfig
 * @Date: 2020-06-05
 * @Time: 19:07
 */
@Configuration
public class RedisConfig {

    @Autowired(required = false)
    StandaloneRedisConfig standaloneRedisConfig;

    @Autowired(required = false)
    ClusterRedisConfig clusterRedisConfig;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory factory = null;
        if (standaloneRedisConfig != null) {
            factory = new JedisConnectionFactory(new RedisStandaloneConfiguration(standaloneRedisConfig.getHost(), standaloneRedisConfig.getPort()));
            return factory;
        }
        if (clusterRedisConfig != null) {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(Arrays.asList(clusterRedisConfig.getNodes().split(",")));
            redisClusterConfiguration.setMaxRedirects(clusterRedisConfig.getMaxRedirects());
            redisClusterConfiguration.setPassword(clusterRedisConfig.getPassword());
            factory = new JedisConnectionFactory(redisClusterConfiguration, jedisPoolConfig);
        }
        return factory;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        return new StringRedisTemplate(redisConnectionFactory);
    }

}
