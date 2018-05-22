package org.stock.eureka.productcstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProductCatalogServiceApplication {

  /**
   * Run the application using Spring Boot and an embedded servlet engine.
   * 
   * @param args Program arguments.
   */
  public static void main(String[] args) {
    SpringApplication.run(ProductCatalogServiceApplication.class, args);
  }
}
