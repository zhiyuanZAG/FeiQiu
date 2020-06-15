package com.zhiyuan.personal.feiqiu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class FeiqiuApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeiqiuApplication.class, args);
		System.out.println("====server Started====");
	}

}
