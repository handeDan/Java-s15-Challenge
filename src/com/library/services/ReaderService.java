package com.library.services;

import com.library.models.Book;
import com.library.models.Reader;
import com.library.repository.ReaderRepository;

public class ReaderService {
    //instance variables:
    private ReaderRepository readerRepository;

    //constructor:
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    //methods:
    //reader that borrowing a book:
    public void borrowBook(String readerId, Book book) {
        Reader reader = readerRepository.getReaderById(readerId);
        if (reader != null) {
            reader.borrowBook(book);
        } else {
            System.out.println("Okuyucu bulunamadı.");
        }
    }

    //reader that returning a book:
    public void returnBook(String readerId, Book book) {
        Reader reader = readerRepository.getReaderById(readerId);
        if (reader != null) {
            reader.returnBook(book);
        } else {
            System.out.println("Okuyucu bulunamadı.");
        }
    }
}
