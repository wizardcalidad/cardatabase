package com.first.cardatabase;

import com.first.cardatabase.domain.Car;
import com.first.cardatabase.domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			// Save demo data to database
			repository.save(new Car("Ford", "Mustang", "Wine", "ADF-1121", 2017, 59000));
			repository.save(new Car("Mercedes", "G-Wagon", "White", "YUS-001", 2018, 60000));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000));

		};
	}

}
