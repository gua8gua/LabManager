package org.nwpu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动入口
 */
@SpringBootApplication
public class LabManagerApplication {

    public static void main(String[] args) {
        // 这一行代码会启动内嵌的 Tomcat 服务器并加载 Spring 环境
        SpringApplication.run(LabManagerApplication.class, args);
    }
}