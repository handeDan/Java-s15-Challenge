package com.library.repository;

import com.library.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books = new ArrayList<>();

    //adding a book to the library:
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Kitap başarıyla eklendi: " + book.getTitle());
    }

    //updating the book
    public void updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId().equals(book.getBookId())) {
                books.set(i, book);
                System.out.println("Kitap başarıyla güncellendi: " + book.getTitle());
                return;
            }
        }
        System.out.println("Kitap bulunamadı.");
    }

    //removing a book from the library:
    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Kitap başarıyla kaldırıldı.");
    }

    public List<Book> getAllBooks() {
        return books;
    }

}
