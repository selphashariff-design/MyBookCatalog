package com.example.mybookcatalog;

public class Book {
    String title;
    String author;
    String genre;
    String description;
    double price;
    int imageResId;

    public Book(String title, String author, String genre, String description, double price, int imageResId) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.price = price;
        this.imageResId = imageResId;
    }
}
