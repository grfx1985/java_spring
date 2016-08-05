package com.wmusial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor // wszystkie konstruktory
@NoArgsConstructor // konstruktor bazowy pusty
@Entity
@Table(name="user")

public @Data class User extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name="email", unique = true)
    private String email;
    private String password;

}
