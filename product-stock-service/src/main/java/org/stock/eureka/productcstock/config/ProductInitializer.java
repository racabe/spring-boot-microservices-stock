package org.stock.eureka.productcstock.config;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.stock.eureka.productcstock.model.Product;
import org.stock.eureka.productcstock.repository.ProductRepository;

/**
 * Class used to initialize the product database.
 */
@Component
public class ProductInitializer implements CommandLineRunner {

  /** The product repository. */
  private final ProductRepository productRepository;

  /**
   * Instantiates a new product initializer.
   *
   * @param productRepository the product repository
   */
  public ProductInitializer(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
   */
  @Override
  public void run(String... args) throws Exception {
    Stream.of("Samsung9", "IphoneX", "Xiaomi Redmi 3", "Monitor Dell", "Keyboard Dell")
        .forEach(productName -> productRepository
            .save(new Product(productName, ThreadLocalRandom.current().nextLong(10))));

    // Only to show by console the products created 
    productRepository.findAll().forEach(System.out::println);
  }
}
