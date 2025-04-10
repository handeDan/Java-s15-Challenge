package com.library.main;

import com.library.models.*;
import com.library.repository.BookRepository;
import com.library.repository.ReaderRepository;
import com.library.services.BookService;
import com.library.services.LibrarianService;
import com.library.services.ReaderService;
import com.library.utils.BillUtil;

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
        Book dostoyevski = new StudyBooks("1", "Dostoyevski", 200.0, true, "1", null, null);
        bookRepository.addBook(dostoyevski);

        Book tolstoy = new Magazines("2", "Tolstoy", 150.0, true, "2", null, null);
        bookRepository.addBook(tolstoy);

        Book gogol = new Journals("3", "Gogol", 100.0, true, "3", null, null);
        bookRepository.addBook(gogol);


        //business logic:
        readerService.borrowBook("12345","1"); //Hande "Dostoyevski" kitabını ödünç aldı.
        readerService.borrowBook("12345","2"); //Hande "Tolstoy" kitabını ödünç aldı.
        readerService.borrowBook("12345","3"); //Hande "Gogol" kitabını ödünç aldı.

        readerService.borrowBook("54321","3"); //Hakan "Gogol" kitabını ödünç aldı.

        readerService.returnBook("12345","3"); //Hande "Gogol" kitabını geri verdi.

        readerService.printAllBooks();
        readerService.borrowBook("12345","1");
        readerService.returnBook("12345","2");

        LibrarianService librarianService = new LibrarianService(bookRepository);
        System.out.println("Faturanız: " + BillUtil.calculateBill(5));
    }
}