package com.iss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 启动类
 */
@SpringBootApplication
public class SameDomainApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SameDomainApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SameDomainApplication.class);
	}

}
