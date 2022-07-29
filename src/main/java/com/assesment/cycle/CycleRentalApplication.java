package com.assesment.cycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CycleRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CycleRentalApplication.class, args);
	}

}
