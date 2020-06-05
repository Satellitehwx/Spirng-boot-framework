package com.javalow.service;

import com.javalow.domain.User;

import java.util.List;

/**
 * @Description: 用户接口
 * @Author: huweixing
 * @ClassName: UserService
 * @Date: 2020-06-05
 * @Time: 10:54
 */
public interface UserService {

    /**
     * 查询所有用户列表
     *
     * @return List
     */
    List<User> getAllUser();

    /**
     * @param userId 用户id
     * @return User
     */
    User getUserById(Integer userId);

}
