package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sales {

    @Id
    @GeneratedValue
    private long Id;
    @Column(length = 11)
    private long UserBookstore;
    @Column(length = 11)
    private long Book;
    @Column(length = 11)
    private long CustomerPayment;
    @Column(length = 11)
    private long OldStock;
    @Column(length = 11)
    private long NewStock;
    private java.sql.Date RegDate;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }


    public long getUserBookstore() {
        return UserBookstore;
    }

    public void setUserBookstore(long userBookstore) {
        this.UserBookstore = userBookstore;
    }


    public long getBook() {
        return Book;
    }

    public void setBook(long book) {
        this.Book = book;
    }


    public long getCustomerPayment() {
        return CustomerPayment;
    }

    public void setCustomerPayment(long customerPayment) {
        this.CustomerPayment = customerPayment;
    }


    public long getOldStock() {
        return OldStock;
    }

    public void setOldStock(long oldStock) {
        this.OldStock = oldStock;
    }


    public long getNewStock() {
        return NewStock;
    }

    public void setNewStock(long newStock) {
        this.NewStock = newStock;
    }


    public java.sql.Date getRegDate() {
        return RegDate;
    }

    public void setRegDate(java.sql.Date regDate) {
        this.RegDate = regDate;
    }

}
