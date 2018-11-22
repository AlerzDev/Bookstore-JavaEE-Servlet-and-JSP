package entities;


public class ShoppingCart {

  private long id;
  private long userBookstore;
  private long book;
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


  public java.sql.Date getRegDate() {
    return regDate;
  }

  public void setRegDate(java.sql.Date regDate) {
    this.regDate = regDate;
  }

}
