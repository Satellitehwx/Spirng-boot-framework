package com.javalow.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: huweixing
 * @ClassName: StandaloneRedisConfig
 * @Date: 2020-06-05
 * @Time: 18:35
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@ConditionalOnProperty(name = {"spring.redis.type"}, havingValue = "single")
public class StandaloneRedisConfig {

    private String host;

    private Integer port;

}
