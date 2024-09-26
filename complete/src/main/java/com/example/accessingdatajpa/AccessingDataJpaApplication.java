package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {

			String url = "jdbc:mysql://localhost:3306/mysql-container";
			String user = "root";
			String password = "AREP2024";

			try (Connection conn = DriverManager.getConnection(url, user, password)) {
				System.out.println("Conectado a la base de datos");



				repository.save(new Customer("Jack", "Bauer"));
				repository.save(new Customer("Chloe", "O'Brian"));
				repository.save(new Customer("Kim", "Bauer"));
				repository.save(new Customer("David", "Palmer"));
				repository.save(new Customer("Michelle", "Dessler"));


				log.info("Customers found with findAll():");
				log.info("-------------------------------");
				repository.findAll().forEach(customer -> {
					log.info(customer.toString());
				});
				log.info("");


				Customer customer = repository.findById(1L);
				log.info("Customer found with findById(1L):");
				log.info("--------------------------------");
				log.info(customer.toString());
				log.info("");



				log.info("Customer found with findByLastName('Bauer'):");
				log.info("--------------------------------------------");
				repository.findByLastName("Bauer").forEach(bauer -> {
					log.info(bauer.toString());
				});
				log.info("");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		};
	}
}
