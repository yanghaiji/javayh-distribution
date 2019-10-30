package com.javayh.api;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

/**
 * @ClassName javayh-distribution → com.javayh.api → ApiApplication
 * @Description 服务启动类
 * @Author Dylan
 * @Date 2019/10/29 9:10
 * @Version
 */
@Slf4j
@ComponentScan(value = "com.javayh")
@MapperScan(value = "com.javayh.conf.mapper")
@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class);
        log.info("<- 项目启动成功 ->");
    }
}
