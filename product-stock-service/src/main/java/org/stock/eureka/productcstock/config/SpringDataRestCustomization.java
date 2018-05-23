package org.stock.eureka.productcstock.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.stock.eureka.productcstock.model.Product;

/**
 * The Class SpringDataRestCustomization is used to expese the Product ID to the TDO.
 */
@Component
public class SpringDataRestCustomization extends RepositoryRestConfigurerAdapter {

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter#
   * configureRepositoryRestConfiguration(org.springframework.data.rest.core.config.
   * RepositoryRestConfiguration)
   */
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

    config.exposeIdsFor(Product.class);
  }

}
