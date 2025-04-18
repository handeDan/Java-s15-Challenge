package com.library.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public abstract class Book {
    //instance variables:
    private String bookId;
    private String title;
    private double price;
    private boolean status;
    private String edition;
    private LocalDate dateOfPurchase;

    private Author author;

    //constructor:
    public Book(String bookId, String title, double price, boolean status, String edition, Date dateOfPurchase, Author author) {
        this.setBookId(bookId);
        this.setTitle(title);
        this.setPrice(price);
        this.setStatus(status);
        this.setEdition(edition);
        this.setDateOfPurchase();
        this.setAuthor(author);
    }

    //getter and setter methods:
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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

    //display book description:
    public void display() {
        System.out.println("Kitap ID: " + bookId);
        System.out.println("Başlık: " + title);
        System.out.println("Yazar: " + author);
        System.out.println("Fiyat: " + price);
        System.out.println("Durum: " + status);
        System.out.println("Baskı: " + edition);
        System.out.println("Satın Alınma Tarihi: " + dateOfPurchase);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", edition='" + edition + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                ", author=" + author +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(price, book.price) == 0 && status == book.status && Objects.equals(bookId, book.bookId) && Objects.equals(title, book.title) && Objects.equals(edition, book.edition) && Objects.equals(dateOfPurchase, book.dateOfPurchase) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, price, status, edition, dateOfPurchase, author);
    }
}
