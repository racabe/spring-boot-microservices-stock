package org.stock.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * The Class EurekaServiceApplication.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     * 
     * @param args
     *            Program arguments.
     */
  public static void main(String[] args) {
    SpringApplication.run(EurekaServiceApplication.class, args);
  }
}
