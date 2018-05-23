package org.stock.eureka.edge.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.stock.eureka.edge.model.Product;

/**
 * Create a ProductClient interface that uses Feign to talk to the product-catalog-service.
 */
@FeignClient("product-catalog-service")
public interface ProductClient {

  /**
   * Find by id.
   *
   * @param idProduct the id product
   * @return the product
   */
  @GetMapping("/products/{id}")
  Product findById(@PathVariable("id") Long idProduct);

  /**
   * Read products.
   *
   * @return the resources
   */
  @GetMapping("/products")
  Resources<Product> readProducts();

  /**
   * Update product.
   *
   * @param idProduct the id product
   * @param currentProduct the current product
   * @return the response entity
   */
  @PutMapping("/products/{id}")
  ResponseEntity<Product> updateProduct(@PathVariable("id") Long idProduct,
      @RequestBody Product currentProduct);
}
