package de.webalpha.webstore.order.core;


import javax.persistence.Embeddable;

@Embeddable
public class Address {
  private String street;
  private String zip;
  private String place;
  private String country;

  public Address(String street, String zip, String place, String country) {
    this.street = street;
    this.zip = zip;
    this.place = place;
    this.country = country;
  }

  public String getStreet() {
    return street;
  }

  public String getZip() {
    return zip;
  }

  public String getPlace() {
    return place;
  }

  public String getCountry() {
    return country;
  }
}
