package com.library.main;

import com.library.models.Book;
import com.library.models.Reader;
import com.library.repository.BookRepository;
import com.library.repository.ReaderRepository;
import com.library.services.BookService;
import com.library.services.ReaderService;

public class Main {
    public static void main(String[] args) {
        // package yapısı:
        // com.library
        // models # Entity sınıfları
        // services # iş mantığı (kitap ödünç alma, iade vb.)
        // repository # veri saklama işlemleri
        // utils # yardımcı methodlar
        // main # ana çalışma dosyaları

        //creating repositories:
        BookRepository bookRepository = new BookRepository();
        ReaderRepository readerRepository = new ReaderRepository();

        //creating services:
        BookService bookService = new BookService(bookRepository, readerRepository);
        ReaderService readerService = new ReaderService(readerRepository, bookRepository);

        //creating readers:
        Reader hande = new Reader("Hande", "12345", 0);
        readerRepository.addReader(hande);

        Reader hakan = new Reader("Hakan", "54321", 0);
        readerRepository.addReader(hakan);

        Reader nil = new Reader("Nil", "67890", 0);
        readerRepository.addReader(nil);

        //creating books:
        Book dostoyevski = new Book("1", "Dostoyevski", 120.0, "available", "1", null, null);
        bookRepository.addBook(dostoyevski);

        Book tolstoy = new Book("2", "Tolstoy", 150.0, "available", "2", null, null);
        bookRepository.addBook(tolstoy);

        Book gogol = new Book("3", "Gogol", 100.0, "available", "3", null, null);
        bookRepository.addBook(gogol);

        //business logic:
        bookService.borrowBook("1","12345"); //Hande "Dostoyevski" kitabını ödünç aldı.
        bookService.borrowBook("2","12345"); //Hande "Tolstoy" kitabını ödünç aldı.
        bookService.borrowBook("3","12345"); //Hande "Gogol" kitabını ödünç aldı.

        bookService.borrowBook("3","54321"); //Hakan "Gogol" kitabını ödünç aldı.

        bookService.returnBook("12345","3"); //Hande "Gogol" kitabını geri verdi.

        readerService.printAllBooks();
        readerService.borrowBook("12345","1");
        readerService.returnBook("12345","2");


    }
}