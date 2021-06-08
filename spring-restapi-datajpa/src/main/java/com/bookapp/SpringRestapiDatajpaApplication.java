package com.bookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringRestapiDatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestapiDatajpaApplication.class, args);
	}

}
