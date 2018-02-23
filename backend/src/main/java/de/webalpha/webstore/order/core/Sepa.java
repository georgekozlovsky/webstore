package de.webalpha.webstore.order.core;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sepa_payment_method")
public class Sepa extends PaymentMethod {
  private String iban;
  private String bic;

  public Sepa(String iban, String bic) {
    this.iban = iban;
    this.bic = bic;
  }

  public String getIban() {
    return iban;
  }

  public String getBic() {
    return bic;
  }
}
