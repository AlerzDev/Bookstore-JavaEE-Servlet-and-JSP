package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeCard {

    @Id
    @GeneratedValue
    private long Id;
    @Column(length = 45)
    private String Description;
    private java.sql.Date regDate;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }


    public java.sql.Date getRegDate() {
        return regDate;
    }

    public void setRegDate(java.sql.Date regDate) {
        this.regDate = regDate;
    }

}
