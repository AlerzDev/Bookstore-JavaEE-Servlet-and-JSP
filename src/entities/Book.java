package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

  @Id
  @GeneratedValue
  private long Id;
  @Column(length = 45)
  private String Title;
  @Column(length = 11)
  private long ReferenceNumber;
  @Column(length = 11)
  private long Popularity;
  @Column(length = 45)
  private String ISBN;
  @Column(length = 45)
  private String EAN;
  private java.sql.Date Year;
  @Column(length = 11)
  private long NumberOfPages;
  @Column(length = 45)
  private String Edition;
  @Column(length = 10)
  private double Price;
  @Column(length = 11)
  private long Stock;
  @Column(length = 45)
  private String Details;
  private java.sql.Date RegDate;
  @Column(length = 11)
  private long Genre;
  @Column(length = 11)
  private long Format;
  @Column(length = 11)
  private long Editorial;
  @Column(length = 11)
  private long Language;
  @Column(length = 11)
  private long Status;
  private byte[] Image;
  @Column(length = 11)
  private long Author;

  public long getAuthor() {
    return Author;
  }

  public void setAuthor(long author) {
    Author = author;
  }

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    this.Id = id;
  }


  public String getTitle() {
    return Title;
  }

  public void setTitle(String title) {
    this.Title = title;
  }


  public long getReferenceNumber() {
    return ReferenceNumber;
  }

  public void setReferenceNumber(long referenceNumber) {
    this.ReferenceNumber = referenceNumber;
  }


  public long getPopularity() {
    return Popularity;
  }

  public void setPopularity(long popularity) {
    this.Popularity = popularity;
  }


  public String getIsbn() {
    return ISBN;
  }

  public void setIsbn(String isbn) {
    this.ISBN = isbn;
  }


  public String getEan() {
    return EAN;
  }

  public void setEan(String ean) {
    this.EAN = ean;
  }


  public java.sql.Date getYear() {
    return Year;
  }

  public void setYear(java.sql.Date year) {
    this.Year = year;
  }


  public long getNumberOfPages() {
    return NumberOfPages;
  }

  public void setNumberOfPages(long numberOfPages) {
    this.NumberOfPages = numberOfPages;
  }


  public String getEdition() {
    return Edition;
  }

  public void setEdition(String edition) {
    this.Edition = edition;
  }


  public double getPrice() {
    return Price;
  }

  public void setPrice(double price) {
    this.Price = price;
  }


  public long getStock() {
    return Stock;
  }

  public void setStock(long stock) {
    this.Stock = stock;
  }


  public String getDetails() {
    return Details;
  }

  public void setDetails(String details) {
    this.Details = details;
  }


  public java.sql.Date getRegDate() {
    return RegDate;
  }

  public void setRegDate(java.sql.Date regDate) {
    this.RegDate = regDate;
  }


  public long getGenre() {
    return Genre;
  }

  public void setGenre(long genre) {
    this.Genre = genre;
  }


  public long getFormat() {
    return Format;
  }

  public void setFormat(long format) {
    this.Format = format;
  }


  public long getEditorial() {
    return Editorial;
  }

  public void setEditorial(long editorial) {
    this.Editorial = editorial;
  }


  public long getLanguage() {
    return Language;
  }

  public void setLanguage(long language) {
    this.Language = language;
  }


  public long getStatus() {
    return Status;
  }

  public void setStatus(long status) {
    this.Status = status;
  }


  public byte[] getImage() {
    return Image;
  }

  public void setImage(byte[] image) {
    this.Image = image;
  }

}
