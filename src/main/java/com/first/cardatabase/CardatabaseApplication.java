package com.first.cardatabase;

import com.first.cardatabase.domain.Car;
import com.first.cardatabase.domain.CarRepository;
import com.first.cardatabase.domain.Owner;
import com.first.cardatabase.domain.OwnerRepository;
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

	@Autowired
	private OwnerRepository orepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			//add owner objects and save these to db
			Owner owner1 = new Owner("Wizard", "Calidad");
			Owner owner2 = new Owner("Qoyum", "Yusuf");
			orepository.save(owner1);
			orepository.save(owner2);

			// Save demo data to database
			Car car = new Car("Ford", "Mustang", "Wine", "ADF-1121", 2017, 59000, owner1);
			repository.save(car);
			car = new Car("Mercedes", "G-Wagon", "White", "YUS-001", 2018, 60000, owner2);
			repository.save(car);
			car = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
			repository.save(car);
			car = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
			repository.save(car);

		};
	}

}
