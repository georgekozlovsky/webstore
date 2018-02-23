package de.webalpha.webstore.order.core;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Order {
  @Id
  private final UUID id;

  @OneToMany
  private List<Item> items;
  private String promotionCode;

  private String buyerId;

  @Embedded
  private Address shippingAdress;

  @Embedded
  private Address receiptAdress;

  @OneToOne
  private PaymentMethod paymentMethod;
  private OrderStatus orderStatus;

  public Order(UUID id, List<Item> items, String promotionCode, String buyerId, Address shippingAdress, Address receiptAdress, PaymentMethod paymentMethod) {
    this.id = id;
    this.items = items;
    this.promotionCode = promotionCode;
    this.buyerId = buyerId;
    this.shippingAdress = shippingAdress;
    this.receiptAdress = receiptAdress;
    this.paymentMethod = paymentMethod;
    this.orderStatus = OrderStatus.PLACED;
  }

  public UUID getId() {
    return id;
  }

  public List<Item> getItems() {
    return items;
  }

  public String getPromotionCode() {
    return promotionCode;
  }

  public String getBuyerId() {
    return buyerId;
  }

  public Address getShippingAdress() {
    return shippingAdress;
  }

  public Address getReceiptAdress() {
    return receiptAdress;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }
}
