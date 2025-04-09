package com.library.models;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person{
    //instance variables:
    private String id;
    private String name;
    private int noBooksIssued; // Ödünç alınan kitap sayısı

    //constructor:
    public Reader(String name, String id,  int noBooksIssued) {
        super(name);
        this.id = id;
        this.name = name;
        this.noBooksIssued = noBooksIssued;
    }

    //getter and setter methods:
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public void setNoBooksIssued(int noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }

    //methods:
    public void borrowBook(Book book) {
        noBooksIssued++;
    }

    public void returnBook(Book book) {
        noBooksIssued--;
    }

    //overrided abstract method:
    @Override
    public void whoYouAre() {
        System.out.println("Kayıtlı kullanıcı : " + this.getName());
    }

}
