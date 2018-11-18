package com.bookstore.daos;


public class CustomerPaymentCard {

  private long id;
  private long numberCard;
  private java.sql.Date dateExp;
  private long ccv;
  private java.sql.Date regDate;
  private long bank;
  private long typeCard;
  private long companyCard;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getNumberCard() {
    return numberCard;
  }

  public void setNumberCard(long numberCard) {
    this.numberCard = numberCard;
  }


  public java.sql.Date getDateExp() {
    return dateExp;
  }

  public void setDateExp(java.sql.Date dateExp) {
    this.dateExp = dateExp;
  }


  public long getCcv() {
    return ccv;
  }

  public void setCcv(long ccv) {
    this.ccv = ccv;
  }


  public java.sql.Date getRegDate() {
    return regDate;
  }

  public void setRegDate(java.sql.Date regDate) {
    this.regDate = regDate;
  }


  public long getBank() {
    return bank;
  }

  public void setBank(long bank) {
    this.bank = bank;
  }


  public long getTypeCard() {
    return typeCard;
  }

  public void setTypeCard(long typeCard) {
    this.typeCard = typeCard;
  }


  public long getCompanyCard() {
    return companyCard;
  }

  public void setCompanyCard(long companyCard) {
    this.companyCard = companyCard;
  }

}
