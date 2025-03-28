package com.library.models;

public class Librarian extends Person{
    //instance varibles:
    private String password;

    //constructor:
    public Librarian(String name) {
        super(name);
    }

    //methods:
    public String searchBook(Book book) {
        return book.toString();
    }

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
        System.out.println("The librarian is : " + this.getName());
    }
}
