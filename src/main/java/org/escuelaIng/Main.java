package org.escuelaIng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for running the Spring Boot application.
 * It initializes the application context and runs the application.
 */
@SpringBootApplication
public class Main {

    /**
     * Main method to run the Spring Boot application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}