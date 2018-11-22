package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserBookstoreCustomerPayment {

    @Id
    @GeneratedValue
    private long Id;
    @Column(length = 11)
    private long CustomerPayment;
    @Column(length = 11)
    private long UserBookstore;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }


    public long getCustomerPayment() {
        return CustomerPayment;
    }

    public void setCustomerPayment(long customerPayment) {
        this.CustomerPayment = customerPayment;
    }


    public long getUserBookstore() {
        return UserBookstore;
    }

    public void setUserBookstore(long userBookstore) {
        this.UserBookstore = userBookstore;
    }

}
