package com.js.service.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Jim.L
 * @title: Application
 * @projectName web-could
 * @date 2021/12/21
 * @dateTime 22:22
 * @description: TODO
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.js.service.goods.mapper"})
public class CouldGoodsApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CouldGoodsApplication.class).run(args);
    }
}
