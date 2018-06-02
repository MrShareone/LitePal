package com.example.mr_shareone.helloas311.DataModel;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class Book extends DataSupport {
    @Column(unique = true, defaultValue = "unknown")
    String bookName;
    String authorName;
    @Column(ignore = true)
    String price;

    public Book(String bookName, String authorName, String price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
