package com.legoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com"})
public class LegoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LegoWebApplication.class, args);
	}
}
