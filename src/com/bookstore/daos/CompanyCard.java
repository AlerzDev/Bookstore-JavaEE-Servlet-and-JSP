package com.bookstore.daos;


public class CompanyCard {

  private long id;
  private String description;
  private java.sql.Date regDate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public java.sql.Date getRegDate() {
    return regDate;
  }

  public void setRegDate(java.sql.Date regDate) {
    this.regDate = regDate;
  }

}
