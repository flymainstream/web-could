package com.js.could.file;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @author Jim.L
 * @title: CouldFileApplication
 * @projectName web-could
 * @date 2021/12/28
 * @dateTime 23:05
 * @description: TODO
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CouldFileApplication {

    private long times = 50000;

    public static void main(String[] args) {
        new SpringApplicationBuilder(CouldFileApplication.class)
                .application().run(args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofBytes(times * 1024));//设置上传单个文件最大10M
        factory.setMaxRequestSize(DataSize.ofBytes(times * 1024));//设置上传文件总数据最大100M
        return factory.createMultipartConfig();
    }
}
