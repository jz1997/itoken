package com.jzheng.itoken.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * 管理员 服务提供者的 启动类
 * @author jzheng
 * @date 2019/8/9 10:54
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.jzheng.itoken.service.admin.mapper")
public class ServiceAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class, args);
    }
}
