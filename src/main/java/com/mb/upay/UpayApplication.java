package com.mb.upay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mb.upay.mapper")
public class UpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpayApplication.class, args);
	}

}
