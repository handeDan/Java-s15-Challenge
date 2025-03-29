package com.library.models;

public class Librarian extends Person{
    //instance varibles:
    private String password;
    private Library library;

    //constructor:
    public Librarian(String name, String password, Library library) {
        super(name);
        this.password = password;
        this.library = library;
    }

    //methods:
    //public String searchBook(String title) {
    //}

    public void verifyMember() {

    }

    public void issueBook(Book book) {

    }

    public void calculateBill() {

    }

    public void createBill() {

    }

    public void returnBook(Book book) {

    }

    //overrided abstract method:
    @Override
    public void whoYouAre() {
        System.out.println("Kütüphaneci : " + this.getName());
    }
}
