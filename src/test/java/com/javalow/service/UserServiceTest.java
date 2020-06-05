package com.javalow.service;

import com.javalow.JavaLowApplicationTest;
import com.javalow.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: 用户Service接口测试类
 * @author: huweixing
 * @ClassName: UserServiceTest
 * @Date: 2020-06-05
 * @Time: 10:02
 */
@Slf4j
public class UserServiceTest extends JavaLowApplicationTest {

    @Autowired
    UserService userService;

    @Test
    public void getUserById() {
        User user = userService.getUserById(1);
        log.info("=========用户信息=======>{}", user.toString());
    }

}
