package org.stock.eureka.edge.model;

/**
 * Create a Product DTO (Data Transfer Object).
 */
public class Product {

  /** The id. */
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
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Product [id=" + id + ", name=" + name + ", amount=" + amount + "]";
  }

}
