package org.stock.eureka.edge.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stock.eureka.edge.client.ProductClient;
import org.stock.eureka.edge.model.Product;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Create a RestController below the ProductClient to exposes the endpoints.
 */
@RestController
public class ProductApiAdapterRestController {

  /** The product client. */
  private final ProductClient productClient;

  /**
   * Instantiates a new product API adapter rest controller.
   *
   * @param productClient the product client
   */
  public ProductApiAdapterRestController(ProductClient productClient) {
    this.productClient = productClient;
  }

  /**
   * Fallback method called if the server is shutdown
   *
   * @return an empty collection
   */
  public Collection<Product> fallback() {
    return new ArrayList<>();
  }

  /**
   * Get all products in database.
   *
   * @return the collection
   */
  @HystrixCommand(fallbackMethod = "fallback")
  @GetMapping("/products")
  @CrossOrigin(origins = "*")
  public Collection<Product> allProducts() {
    return productClient.readProducts().getContent();
  }
}
