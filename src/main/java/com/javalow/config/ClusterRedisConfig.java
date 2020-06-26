package com.javalow.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: huweixing
 * @ClassName: ClusterRedisConfig
 * @Date: 2020-06-05
 * @Time: 18:37
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.redis.cluster")
@ConditionalOnProperty(name = {"spring.redis.type"}, havingValue = "cluster")
public class ClusterRedisConfig {

    private String nodes;
    private String password;
    private Integer maxRedirects;

}
