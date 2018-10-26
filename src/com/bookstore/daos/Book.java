package com.bookstore.daos;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Book {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int Id;
    @Column(length = 50)
    private String Editorial;
    @Column(length = 150)
    private String Title;
    @Column(length = 10)
    private int ReferenceNumber;
    @Column(length = 6)
    private int Popularity;
    @Column(length = 50)
    private String ISBN;
    @Column(length = 50)
    private String EAN;
    private Date YearCreate;
    @Column(length = 5)
    private int NumberOfPages;
    @Column(length = 50)
    private String Edition;
    @Column(length = 10)
    private double Price;
    @Column(length = 6)
    private int Stock;
    @Column(length = 200)
    private String Details;
    @Column(length = 1)
    private boolean Active;
    private Date RegDate;

    public Book(String editorial, String title, int referenceNumber, int popularity, String ISBN, String EAN, Date yearCreate, int numberOfPages, String edition, double price, int stock, String details, boolean active, Date regDate) {
        Editorial = editorial;
        Title = title;
        ReferenceNumber = referenceNumber;
        this.Popularity = popularity;
        this.ISBN = ISBN;
        this.EAN = EAN;
        YearCreate = yearCreate;
        NumberOfPages = numberOfPages;
        Edition = edition;
        Price = price;
        Stock = stock;
        Details = details;
        Active = active;
        RegDate = regDate;
    }

    public Book() {
        super();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getReferenceNumber() {
        return ReferenceNumber;
    }

    public void setReferenceNumber(int referenceNumber) {
        ReferenceNumber = referenceNumber;
    }

    public int getPopularity() {
        return Popularity;
    }

    public void setPopularity(int popularity) {
        this.Popularity = popularity;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getEAN() {
        return EAN;
    }

    public void setEAN(String EAN) {
        this.EAN = EAN;
    }

    public Date getYearCreate() {
        return YearCreate;
    }

    public void setYearCreate(Date yearCreate) {
        YearCreate = yearCreate;
    }

    public int getNumberOfPages() {
        return NumberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        NumberOfPages = numberOfPages;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String edition) {
        Edition = edition;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public Date getRegDate() {
        return RegDate;
    }

    public void setRegDate(Date regDate) {
        RegDate = regDate;
    }

    @Override
    public String toString() {
        return "book{" +
                "Id=" + Id +
                ", Editorial='" + Editorial + '\'' +
                ", Title='" + Title + '\'' +
                ", ReferenceNumber=" + ReferenceNumber +
                ", popularity=" + Popularity +
                ", ISBN='" + ISBN + '\'' +
                ", EAN='" + EAN + '\'' +
                ", YearCreate=" + YearCreate +
                ", NumberOfPages=" + NumberOfPages +
                ", Edition='" + Edition + '\'' +
                ", Price=" + Price +
                ", Stock='" + Stock + '\'' +
                ", Details='" + Details + '\'' +
                ", Active=" + Active +
                ", RegDate=" + RegDate +
                '}';
    }
}
