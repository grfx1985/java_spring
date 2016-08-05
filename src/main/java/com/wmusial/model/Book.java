package com.wmusial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor // wszystkie konstruktory
@NoArgsConstructor // konstruktor bazowy pusty
@Entity
@Table(name="book")
public @Data class Book extends BaseEntity {


    private String title;
    private String author;
    private int available; // ile dostepnych

    public void decrementAvailable() {
        if (this.available > 0) {
            this.available = this.available - 1;
        }
    }


    public void incrementAvailable() {
            this.available = this.available + 1;
    }

//    public Book() {
//    }
//
//    public Book(String title, String author, int available) {
//        this.title = title;
//        this.author = author;
//        this.available = available;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public int getAvailable() {
//        return available;
//    }
//
//    public void setAvailable(int available) {
//        this.available = available;
//    }


}
