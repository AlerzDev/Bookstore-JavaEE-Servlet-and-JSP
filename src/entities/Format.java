package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Format {

  @Id
  @GeneratedValue
  private long Id;
  @Column(length = 45)
  private String Description;
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


  public java.sql.Date getRegDate() {
    return RegDate;
  }

  public void setRegDate(java.sql.Date regDate) {
    this.RegDate = regDate;
  }

}
