package com.wmusial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor // wszystkie konstruktory
@NoArgsConstructor // konstruktor bazowy pusty
@Entity
@Table(name="rent")

public @Data class Rent extends BaseEntity {

    public enum Status { IN_PROGRESS , FINISHED }
    @Column(name="return_date")
    private Date returnDate;
    @Column(name="rent_date")
    private Date rentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="book_id")
    private Status book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;


    @Enumerated(EnumType.STRING)
    private Status status = Status.IN_PROGRESS;
}
