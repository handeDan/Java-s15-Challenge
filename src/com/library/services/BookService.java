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
    //borrowing a book:
    public void borrowBook(String bookId, String readerId) {
        Reader reader = readerRepository.getReaderById(readerId);
        Book book = findBookById(bookId);

        //controlling before borrowing a book:
        if (reader == null) {
            System.out.println("Okuyucu bulunamadı.");
            return;
        }
        if (book == null) {
            System.out.println("Kitap bulunamadı.");
            return;
        }
        if (book.getStatus().equals("borrowed")) {
            System.out.println("Kitap zaten ödünç alınmış.");
            return;
        }
        if (reader.getNoBooksIssued() >= 5) {
            System.out.println("Okuyucu kitap limitine ulaşmış.");
            return;
        }

        //borrowed a book:
        reader.borrowBook(book);
        book.setStatus("borrowed");

            // issued the bill..
            double amount = book.getPrice();
            String billId = Integer.toString(new Random().nextInt()); //rastgele bir integer üretir ve string'e çevirir.
            Bill bill = new Bill(billId, reader, book, amount);
            bill.displayBill();
            System.out.println("Kitap ödünç alındı ve fatura kesildi.");
    }


    //returning a book:
    public void returnBook(String readerId, String bookId) {
        Reader reader = readerRepository.getReaderById(readerId);
        Book book = findBookById(bookId);

        //controlling before returning a book:
        if (reader == null) {
            System.out.println("Okuyucu bulunamadı.");
            return;
        }
        if (book == null) {
            System.out.println("Kitap bulunamadı.");
            return;
        }
        if (book.getStatus().equals("available")) {
            System.out.println("Kitap zaten iade edilmiş.");
            return;
        }

        //returning a book:
        reader.returnBook(book);
        book.setStatus("available");

        //billing after returning a book:
        System.out.println("Kitap iade edildi.");
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
