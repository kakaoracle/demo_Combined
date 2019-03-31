package com.iss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * <br>
 * 标题: 启动类<br>
 */
@SpringBootApplication
public class CrossDomainApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CrossDomainApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CrossDomainApplication.class);
    }

}
