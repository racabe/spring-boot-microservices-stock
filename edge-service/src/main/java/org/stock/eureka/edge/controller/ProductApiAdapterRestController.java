package org.stock.eureka.edge.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  
  /**
   * Update product.
   *
   * @param currentProduct the current product
   * @return the product
   */
  @PutMapping("/products/{id}")
  @CrossOrigin(origins = "*")
  public ResponseEntity<String> updateProduct(@PathVariable("id") Long idProduct, @RequestBody Product currentProduct) {
    System.out.println(currentProduct);
    
    Product product = productClient.findById(idProduct);
    if (product==null) {
        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }
    product.setId(idProduct);
    product.setName(currentProduct.getName());
    product.setAmount(currentProduct.getAmount());
    productClient.updateProduct(idProduct, product);
    
    return new ResponseEntity<String>(HttpStatus.OK);
  }
}
