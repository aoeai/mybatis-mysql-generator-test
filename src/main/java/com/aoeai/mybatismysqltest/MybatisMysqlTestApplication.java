package com.aoeai.mybatismysqltest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.*"})
@MapperScan(basePackages="com.aoeai.mybatismysqltest.mapper")
public class MybatisMysqlTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisMysqlTestApplication.class, args);
    }
}
