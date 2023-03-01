package com.alpha.mapstructdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(
		exclude = {
				ThymeleafAutoConfiguration.class,
		}
)
@EnableAsync
public class MapstructDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapstructDemoApplication.class, args);
	}

}
