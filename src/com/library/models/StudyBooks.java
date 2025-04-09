package com.library.models;

import java.util.Date;

public class StudyBooks extends Book {
    public StudyBooks(String bookId, String title, double price, boolean status, String edition, Date dateOfPurchase, Author author) {
        super(bookId, title, price, status, edition, dateOfPurchase, author);
    }
}
