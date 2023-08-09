package com.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BondsMgmtBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BondsMgmtBackendApplication.class, args);
		
		System.out.println("Application started!");
	}
}
