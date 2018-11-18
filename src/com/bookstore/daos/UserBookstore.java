package com.bookstore.daos;


public class UserBookstore {

  private long id;
  private String username;
  private String email;
  private String password;
  private String street;
  private String colony;
  private String phone;
  private String image;
  private java.sql.Date regDate;
  private long postalCode;
  private long status;
  private long municipality;
  private long country;
  private long state;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }


  public String getColony() {
    return colony;
  }

  public void setColony(String colony) {
    this.colony = colony;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public java.sql.Date getRegDate() {
    return regDate;
  }

  public void setRegDate(java.sql.Date regDate) {
    this.regDate = regDate;
  }


  public long getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(long postalCode) {
    this.postalCode = postalCode;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getMunicipality() {
    return municipality;
  }

  public void setMunicipality(long municipality) {
    this.municipality = municipality;
  }


  public long getCountry() {
    return country;
  }

  public void setCountry(long country) {
    this.country = country;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }

}
