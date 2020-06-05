package com.javalow.service.impl;

import com.javalow.domain.User;
import com.javalow.mapper.UserMapper;
import com.javalow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 用户接口实现类
 * @author: huweixing
 * @ClassName: UserServiceImpl
 * @Date: 2020-06-05
 * @Time: 10:54
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
