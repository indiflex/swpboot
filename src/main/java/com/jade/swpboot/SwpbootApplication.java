package com.jade.swpboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.jade.swpboot.mapper"})
public class SwpbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwpbootApplication.class, args);
	}
}
