package com.javalow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: huweixing
 * @ClassName: JavaLowApplication
 * @Date: 2020-06-02
 * @Time: 16:51
 */
@SpringBootApplication
/*@MapperScan("com.javalow.mapper")*/
public class JavaLowApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLowApplication.class, args);
    }

}
