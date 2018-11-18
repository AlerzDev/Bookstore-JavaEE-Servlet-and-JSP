package com.bookstore.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {

  @Id
  @GeneratedValue
  private long Id;
  @Column(length = 45)
  private String FullName;
  private java.sql.Date YearOfBirth;
  @Column(length = 11)
  private long Municipality;
  @Column(length = 11)
  private long State;
  @Column(length = 11)
  private long Country;
  private java.sql.Date RegDate;
  @Column(length = 11)
  private long Status;

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    this.Id = id;
  }


  public String getFullName() {
    return FullName;
  }

  public void setFullName(String fullName) {
    this.FullName = fullName;
  }


  public java.sql.Date getYearOfBirth() {
    return YearOfBirth;
  }

  public void setYearOfBirth(java.sql.Date yearOfBirth) {
    this.YearOfBirth = yearOfBirth;
  }


  public long getMunicipality() {
    return Municipality;
  }

  public void setMunicipality(long municipality) {
    this.Municipality = municipality;
  }


  public long getState() {
    return State;
  }

  public void setState(long state) {
    this.State = state;
  }


  public long getCountry() {
    return Country;
  }

  public void setCountry(long country) {
    this.Country = country;
  }


  public java.sql.Date getRegDate() {
    return RegDate;
  }

  public void setRegDate(java.sql.Date regDate) {
    this.RegDate = regDate;
  }


  public long getStatus() {
    return Status;
  }

  public void setStatus(long status) {
    this.Status = status;
  }

}
