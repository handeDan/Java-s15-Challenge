package com.library.models;

import java.util.Date;

public class Magazines extends Book {
    public Magazines(String bookId, String title, double price, boolean status, String edition, Date dateOfPurchase, Author author) {
        super(bookId, title, price, status, edition, dateOfPurchase, author);
    }
}
