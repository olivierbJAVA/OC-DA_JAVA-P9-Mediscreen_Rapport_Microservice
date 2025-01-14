package com.mediscreen.rapport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Class in charge of launching the Rapport Microservices in charge of producing patient diabetes risk assessment report.
 */
@SpringBootApplication
@EnableFeignClients("com.mediscreen.rapport")
public class RapportApplication {

	public static void main(String[] args) {
		SpringApplication.run(RapportApplication.class, args);
	}

}
