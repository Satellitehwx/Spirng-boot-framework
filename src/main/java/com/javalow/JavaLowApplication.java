package com.javalow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @description:
 * @author: huweixing
 * @ClassName: JavaLowApplication
 * @Date: 2020-06-02
 * @Time: 16:51
 */
@SpringBootApplication
// 扫描mapper所在的包 开启注解 mapper接口可以不添加@mapper注解
/*@MapperScan("com.javalow.mapper")*/
@EnableCaching
public class JavaLowApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLowApplication.class, args);
    }

}
