package org.stock.eureka.edge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 */
@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class EdgeServiceApplication {

  /**
   * Run the application using Spring Boot and an embedded servlet engine.
   * 
   * @param args Program arguments.
   */
  public static void main(String[] args) {
    SpringApplication.run(EdgeServiceApplication.class, args);
  }
}
