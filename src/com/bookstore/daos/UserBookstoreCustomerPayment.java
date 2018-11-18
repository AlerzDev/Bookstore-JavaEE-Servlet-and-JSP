package com.bookstore.daos;


public class UserBookstoreCustomerPayment {

  private long id;
  private long customerPayment;
  private long userBookstore;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCustomerPayment() {
    return customerPayment;
  }

  public void setCustomerPayment(long customerPayment) {
    this.customerPayment = customerPayment;
  }


  public long getUserBookstore() {
    return userBookstore;
  }

  public void setUserBookstore(long userBookstore) {
    this.userBookstore = userBookstore;
  }

}
