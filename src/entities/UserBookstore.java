package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.sql.Date;

@Entity
public class UserBookstore {

    @javax.persistence.Id
    @GeneratedValue
    private long Id;
    @Column(length = 45)
    private String Username;
    @Column(length = 45)
    private String Email;
    @Column(length = 45)
    private String Password;
    @Column(length = 45)
    private String Street;
    @Column(length = 45)
    private String Colony;
    @Column(length = 45)
    private String Phone;
    private byte[] Image;
    @Column(length = 45)
    private Date RegDate;
    @Column(length = 11)
    private long PostalCode;
    private long Status;
    @Column(length = 11)
    private long Municipality;
    @Column(length = 11)
    private long Country;
    @Column(length = 11)
    private long State;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }


    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        this.Street = street;
    }


    public String getColony() {
        return Colony;
    }

    public void setColony(String colony) {
        this.Colony = colony;
    }


    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }


    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        this.Image = image;
    }


    public java.sql.Date getRegDate() {
        return RegDate;
    }

    public void setRegDate(java.sql.Date regDate) {
        this.RegDate = regDate;
    }


    public long getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(long postalCode) {
        this.PostalCode = postalCode;
    }


    public long getStatus() {
        return Status;
    }

    public void setStatus(long status) {
        this.Status = status;
    }


    public long getMunicipality() {
        return Municipality;
    }

    public void setMunicipality(long municipality) {
        this.Municipality = municipality;
    }


    public long getCountry() {
        return Country;
    }

    public void setCountry(long country) {
        this.Country = country;
    }


    public long getState() {
        return State;
    }

    public void setState(long state) {
        this.State = state;
    }

}
