package com.library.services;

import com.library.models.Book;
import com.library.models.Reader;
import com.library.repository.BookRepository;
import com.library.repository.ReaderRepository;

public class ReaderService {
    //instance variables:
    private ReaderRepository readerRepository;
    private BookRepository bookRepository;

    //constructor:
    public ReaderService(ReaderRepository readerRepository, BookRepository bookRepository) {
        this.readerRepository = readerRepository;
        this.bookRepository = bookRepository;
    }

    //methods:
    //reader that borrowing a book:
    public void borrowBook(String readerId, String bookId) {
        Reader reader = readerRepository.getReaderById(readerId);
        Book book = findBookById(bookId);

        if (reader != null && book != null) {
            if (reader.getNoBooksIssued() < 5) {
                reader.borrowBook(book);
                book.setStatus("borrowed");
                System.out.println(reader.getName() + " kitap ödünç aldı: " + book.getTitle());
            } else {
                System.out.println(reader.getName() + " kitap limitine ulaşmış.");
            }
        } else {
            System.out.println("Kitap veya okuyucu bulunamadı.");
        }
    }

    //reader that returning a book:
    public void returnBook(String readerId, String bookId) {
        Reader reader = readerRepository.getReaderById(readerId);
        Book book = findBookById(bookId);

        if (reader != null && book != null && book.getStatus().equals("borrowed")) {
            reader.returnBook(book);
            book.setStatus("available");
            System.out.println(reader.getName() + " kitap iade etti: " + book.getTitle());
        } else {
            System.out.println("Kitap iade edilemedi.");
        }
    }

    //finding a book by its id:
    private Book findBookById(String bookId) {
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }
}
