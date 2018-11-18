package com.bookstore.daos;

import javax.persistence.*;

@Entity
public class State {

    @Id
    @GeneratedValue
    private long Id;

    @Column(length = 45)
    private String Description;

    @Column(length = 11)
    private long Country;
    private java.sql.Date RegDate;


    public long getId() {
        return Id;
      }
      public void setId(long id) {
        this.Id = id;
      }


      public String getDescription() {
        return Description;
      }

      public void setDescription(String description) {
        this.Description = description;
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

}
