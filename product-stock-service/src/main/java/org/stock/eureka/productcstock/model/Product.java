package org.stock.eureka.productcstock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class Product.
 */
@Entity
public class Product {

  /** The id. */
  @Id
  @GeneratedValue
  private Long id;

  /** The name. */
  private String name;

  /** The amount. */
  private Long amount;

  /**
   * Instantiates a new product.
   */
  public Product() {}

  /**
   * Instantiates a new product.
   *
   * @param name the name
   * @param amount the amount
   */
  public Product(String name, Long amount) {
    this.name = name;
    this.amount = amount;
  }

  /**
   * Instantiates a new product.
   *
   * @param id the id
   * @param name the name
   * @param amount the amount
   */
  public Product(Long id, String name, Long amount) {
    this.id = id;
    this.name = name;
    this.amount = amount;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the amount.
   *
   * @return the amount
   */
  public Long getAmount() {
    return amount;
  }

  /**
   * Sets the amount.
   *
   * @param amount the new amount
   */
  public void setAmount(Long amount) {
    this.amount = amount;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 17;
    result = prime * result + ((id == null) ? 0 : (int) (id ^ (id >>> 32)));
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Product [name=" + name + ", amount=" + amount + "]";
  }

}
