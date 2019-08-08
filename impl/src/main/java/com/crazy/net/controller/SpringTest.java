package com.crazy.net.controller;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author yufeng li
 * @title: SpringTest
 * @description:
 * @date 2019/6/28 16:03
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})//这里的MybatisAutoConfiguration.class对应你的数据库框架
public class SpringTest {

    public static void main(String[] args) {
        SpringApplication.run(SpringTest.class, args);
    }
}