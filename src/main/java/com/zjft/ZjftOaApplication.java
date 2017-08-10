package com.zjft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zjft.mapper")
public class ZjftOaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZjftOaApplication.class, args);
	}
}
