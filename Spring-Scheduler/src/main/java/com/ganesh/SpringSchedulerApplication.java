package com.ganesh;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class SpringSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedulerApplication.class, args);
	}
	//PT1H, PT10M, PT05S
	//@Scheduled(initialDelay=1000L ,fixedRate = 2000L) 
	@Scheduled(initialDelay=1000L, fixedDelayString="PT02M")
	void myTaskOne() throws InterruptedException {
		System.out.println("Now Date is =>"+ new Date());
		Thread.sleep(1000L);
	}

}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name="scheduling.enabled", matchIfMissing=true)
class SchedulingConfiguration {
	
}
