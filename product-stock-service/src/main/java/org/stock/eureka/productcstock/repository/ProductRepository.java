package org.stock.eureka.productcstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.stock.eureka.productcstock.model.Product;

/**
 * Repository for Product data implemented using Spring Data JPA.
 */
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
