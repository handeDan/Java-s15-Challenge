package com.library.models;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person{
    //instance variables:
    private Set<Book> borrowedBooks; //set: keep only unique data!

    //constructor:
    public Reader(String name, Set<Book> borrowedBooks) {
        super(name);
        this.borrowedBooks = new HashSet<>(); //created an empty HashSet
        //HashSet: keep only unique data!
    }

    //getter and setter methods:
    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Set<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    //methods:
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public void whoYouAre() {
        System.out.println("The reader of the book is : " + this.getName());
    }
}
