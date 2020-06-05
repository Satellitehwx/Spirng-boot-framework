package com.javalow.service;

import com.javalow.JavaLowApplicationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @description: 打包测试类
 * @author: huweixing
 * @ClassName: TestSuits
 * @Date: 2020-06-05
 * @Time: 14:48
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({UserServiceTest.class})
public class ServiceSuits extends JavaLowApplicationTest {
    //打包测试类 不需要 写代码
    //SuiteClasses 里面添加多个services即可
}
