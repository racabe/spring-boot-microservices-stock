package org.stock.eureka.edge.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.stock.eureka.edge.model.Product;

/**
 * Create a ProductClient interface that uses Feign to talk to the product-catalog-service.
 */
@FeignClient("product-catalog-service")
public interface ProductClient {

  /**
   * Read products.
   *
   * @return the resources
   */
  @GetMapping("/products")
  Resources<Product> readProducts();
}
