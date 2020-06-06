package com.javalow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: redis测试
 * @author: huweixing
 * @ClassName: RedisController
 * @Date: 2020-06-05
 * @Time: 17:44
 */
@RestController
@RequestMapping("/api/redis")
public class RedisController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/setValue")
    public String setValue() {
        stringRedisTemplate.opsForValue().set("aa", "111111111");
        return "成功";
    }

    @RequestMapping("/getValue")
    public Object getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

}
