package com.library.models;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person{
    //instance variables:
    private String id;
    private String name;
    private int noBooksIssued; // Ödünç alınan kitap sayısı

    //constructor:
    public Reader(String name, String id, String name1, int noBooksIssued) {
        super(name);
        this.id = id;
        this.name = name1;
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
    //borrowing a book:
    public void borrowBook(Book book) {
        if (noBooksIssued < 5) {
            noBooksIssued++;
            System.out.println(name + " kitap ödünç aldı: " + book.getTitle());
        } else {
            System.out.println(name + " ödünç alabileceği kitap limitine ulaştı.");
        }
    }

    //returning a book:
    public void returnBook(Book book) {
        if (noBooksIssued > 0) {
            noBooksIssued--;
            System.out.println(name + " kitap iade etti: " + book.getTitle());
        } else {
            System.out.println(name + " iade edilecek kitap bulunmuyor.");
        }
    }

    //overrided abstract method:
    @Override
    public void whoYouAre() {
        System.out.println("Kayıtlı kullanıcı : " + this.getName());
    }
}
