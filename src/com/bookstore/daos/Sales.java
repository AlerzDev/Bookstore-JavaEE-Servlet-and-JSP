package com.bookstore.daos;


public class Sales {

  private long id;
  private long userBookstore;
  private long book;
  private long customerPayment;
  private long oldStock;
  private long newStock;
  private java.sql.Date regDate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserBookstore() {
    return userBookstore;
  }

  public void setUserBookstore(long userBookstore) {
    this.userBookstore = userBookstore;
  }


  public long getBook() {
    return book;
  }

  public void setBook(long book) {
    this.book = book;
  }


  public long getCustomerPayment() {
    return customerPayment;
  }

  public void setCustomerPayment(long customerPayment) {
    this.customerPayment = customerPayment;
  }


  public long getOldStock() {
    return oldStock;
  }

  public void setOldStock(long oldStock) {
    this.oldStock = oldStock;
  }


  public long getNewStock() {
    return newStock;
  }

  public void setNewStock(long newStock) {
    this.newStock = newStock;
  }


  public java.sql.Date getRegDate() {
    return regDate;
  }

  public void setRegDate(java.sql.Date regDate) {
    this.regDate = regDate;
  }

}
