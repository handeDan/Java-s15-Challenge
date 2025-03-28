package com.library.models;

import java.time.LocalDate;
import java.util.Date;

public class Book {
    //instance variables:
    private Long bookId;
    private String name;
    private double price;
    private String status;
    private String edition;
    private LocalDate dateOfPurchase;

    private Author author;

    //constructor:
    public Book(Long bookId, String name, double price, String status, String edition, Date dateOfPurchase, Author author) {
        this.setBookId(bookId);
        this.setName(name);
        this.setPrice(price);
        this.setStatus(status);
        this.setEdition(edition);
        this.setDateOfPurchase();
        this.setAuthor(author);
    }

    //getter and setter methods:
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase() {
        this.dateOfPurchase = LocalDate.now(); //today's date
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
