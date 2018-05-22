package org.stock.eureka.edge.model;

/**
 * Create a Product DTO (Data Transfer Object).
 */
public class Product {

  /** The name. */
  private String name;

  /** The amount. */
  private Long amount;

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

}
