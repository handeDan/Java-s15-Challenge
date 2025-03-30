package com.library.services;

import com.library.models.Bill;
import com.library.models.Book;
import com.library.models.Reader;
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

        if (reader != null && book != null && book.getStatus().equals("available")) {
            // book is borrowed..
            reader.borrowBook(book);
            book.setStatus("borrowed");

            // issued the bill..
            double amount = book.getPrice();
            String billId = Integer.toString(new Random().nextInt()); //rastgele bir integer üretir ve string'e çevirir.
            Bill bill = new Bill(billId, reader, book, amount);
            bill.displayBill();
            System.out.println("Fatura kesildi.");
        } else {
            System.out.println("Kitap ödünç alınamadı.");
        }
    }

    //returning a book:
    public void returnBook(String bookId, String readerId) {
        Reader reader = readerRepository.getReaderById(readerId);
        Book book = findBookById(bookId);

        if (reader != null && book != null && book.getStatus().equals("borrowed")) {
            // Kitap iade ediliyor
            reader.returnBook(book);
            book.setStatus("available");

            // Fatura ödeme işlemi
            // İade edilen kitapla ilgili faturayı ödemek için
            // burada ödeme işlemi yapılabilir
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
