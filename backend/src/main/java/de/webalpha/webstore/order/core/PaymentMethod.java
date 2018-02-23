package de.webalpha.webstore.order.core;

import javax.persistence.*;

@Entity
@Table(name = "payment_method")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentMethod {
  @Id
  private String txId;

}
