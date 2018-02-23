package de.webalpha.webstore.order.core;

import de.webalpha.webstore.inventory.persistence.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToOne
  private Product product;
  private BigDecimal itemPrice;
  private int quantity;

  public Item(Product product, BigDecimal itemPrice, int quantity) {
    this.product = product;
    this.itemPrice = itemPrice;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public BigDecimal getItemPrice() {
    return itemPrice;
  }

  public int getQuantity() {
    return quantity;
  }
}
