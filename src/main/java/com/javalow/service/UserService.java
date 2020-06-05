package com.javalow.service;

import com.javalow.domain.User;

/**
 * @Description: 用户接口
 * @Author: huweixing
 * @ClassName: UserService
 * @Date: 2020-06-05
 * @Time: 10:54
 */
public interface UserService {

    public User getUserById(Integer userId);

}
