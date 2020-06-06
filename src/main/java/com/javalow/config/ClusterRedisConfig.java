package com.javalow.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: huweixing
 * @ClassName: ClusterRedisConfig
 * @Date: 2020-06-05
 * @Time: 18:37
 */
@Getter
@Setter
@Component
public class ClusterRedisConfig {

    @Value("${spring.redis.cluster.nodes}")
    private String nodes;
    @Value("${spring.redis.cluster.password}")
    private String password;
    @Value("${spring.redis.cluster.max-redirects}")
    private int maxRedirects;

}
