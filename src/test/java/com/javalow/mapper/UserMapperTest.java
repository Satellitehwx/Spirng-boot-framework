package com.javalow.mapper;

import com.javalow.JavaLowApplicationTest;
import com.javalow.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: 用户mapper接口单元测试
 * @author: huweixing
 * @ClassName: UserMapperTest
 * @Date: 2020-06-05
 * @Time: 11:14
 */
@Slf4j
public class UserMapperTest extends JavaLowApplicationTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void getUserById() {
        User user = userMapper.selectByPrimaryKey(1);
        log.info("=========用户信息=======>{}", user.toString());
    }
}
