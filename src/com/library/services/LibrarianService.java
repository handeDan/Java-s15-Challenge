package com.library.services;

import com.library.models.Book;
import com.library.repository.BookRepository;
import com.library.utils.BillUtil;

import java.util.Optional;

public class LibrarianService {
    private BookRepository bookRepository;

    public LibrarianService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> searchBook(String title) {
        return bookRepository.getAllBooks()
                .stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public void issueBook(String bookId) {
        Book book = bookRepository.getBookById(bookId);

        if (!book.getStatus()) {
            book.setStatus(true);
            System.out.println(book.getTitle() + " kitabı ödünç verildi.");
        } else {
            System.out.println("Bu kitap şu anda başka bir kullanıcıda.");
        }
    }

    public void createBill(String memberId, int daysLate) {
        double billAmount = BillUtil.calculateBill(daysLate);
        System.out.println("Üye " + memberId + " için " + billAmount + " TL gecikme ücreti oluşturuldu.");
    }

    public void returnBook(Book book) {
        Book returnedBook = bookRepository.getBookById(book.getBookId());

            returnedBook.setStatus(false);
            System.out.println(book.getTitle() + " kitabı iade verildi.");

    }
}
