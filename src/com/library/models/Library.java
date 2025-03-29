package com.library.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    //instance variables:
    private List<Book> books;
    private List<Reader> readers;

    //constructor:
    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    //getter and setter methods:
    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    //methods:




    //searching a book from the library:
    public Optional<Book> searchBook(String title) {
        return  books.stream()
                .filter(book -> book.getTitle()
                        .equalsIgnoreCase(title))
                .findFirst();
    }

    //adding a reader to the library:
    public void addReader(Reader reader) {
        readers.add(reader);
        System.out.println(reader.getName() + " kayıtlı kullanıcılara eklendi.");
    }

    //removing a reader from the library:
    public void removeReader(Reader reader) {
        readers.remove(reader);
        System.out.println(reader.getName() + " kayıtlı kullanıcılardan kaldırıldı.");
    }

}
