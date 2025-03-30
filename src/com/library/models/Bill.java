package com.library.models;

public class Bill {
    //instance variables:
    private String billId;
    private Reader reader;
    private Book book;
    private double price;
    private boolean isPaid; //ödeme durumu

    //constructor:
    public Bill(String billId, Reader reader, Book book, double price) {
        this.billId = billId;
        this.reader = reader;
        this.book = book;
        this.price = price;
    }

    //getter and setter methods:

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    //methods:
    //paying:
    public void payBill() {
        isPaid = true;
        System.out.println("Fatura ödendi. Fatura id : " + billId);
    }

    //display bill description:
    public void displayBill() {
        System.out.println("Fatura ID: " + billId);
        System.out.println("Okuyucu: " + reader.getName());
        System.out.println("Kitap: " + book.getTitle());
        System.out.println("Tutar: " + price);
        System.out.println("Ödeme Durumu: " + (isPaid ? "Ödendi" : "Ödenmedi"));
    }
}
