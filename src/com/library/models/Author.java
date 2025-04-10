package com.library.models;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Author extends Person{
    //instance variables:
    private Set<Book> books; //set: keep only unique data!

    //constructor
    public Author(String name) {
        super(name); //parent class
        this.books = new HashSet<>(); //created an empty HashSet
       //HashSet: keep only unique data!
    }

    //methods:
    public void newBook(Book book) {
        books.add(book);
    }

    public Set<Book> showBook() {
        return books.stream().collect(Collectors.toUnmodifiableSet()); //sadece read
    }

    //overrided abstract method:
    @Override
    public void whoYouAre() {
        System.out.println("Kitabın yazarı : " + this.getName());
    }
}