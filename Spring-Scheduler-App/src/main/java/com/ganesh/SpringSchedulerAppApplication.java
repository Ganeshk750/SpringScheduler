package com.ganesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringSchedulerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedulerAppApplication.class, args);
	}

}
