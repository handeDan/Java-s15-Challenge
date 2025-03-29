package com.library.services;

import com.library.repository.BookRepository;

public class BookService {
    //instance variables:
    private BookRepository bookRepository;

    //constructor:
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //methods:
    //borrowing a book:
    public void borrowBook(String bookId) {
        // Kitap ödünç alınabilir mi kontrolü yapılacak
        // Örneğin: Kitap mevcut mu, başkası tarafından ödünç alındı mı vb.
    }

    //returning a book:
    public void returnBook(String bookId) {
        // Kitap iade işlemi yapılacak
    }

    //issuing bill:
    public void issueBill(String bookId) {
        // Kitap için fatura işlemi yapılacak
    }
}
