package com.niltonrodriguez.SkateRental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.niltonrodriguez.SkateRental.entity"})
@SpringBootApplication
public class SkateRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkateRentalApplication.class, args);
	}

}
