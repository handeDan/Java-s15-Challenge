package com.library.services;

import com.library.models.Book;
import com.library.models.Reader;
import com.library.models.Bill;
import com.library.repository.BookRepository;
import com.library.repository.ReaderRepository;

import java.util.Random;

public class BookService {
    //instance variables:
    private BookRepository bookRepository;
    private ReaderRepository readerRepository;

    //constructor:
    public BookService(BookRepository bookRepository, ReaderRepository readerRepository) {
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
    }

    //methods:
    //updating the book
    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

}
