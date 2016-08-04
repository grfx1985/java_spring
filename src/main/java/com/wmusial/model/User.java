package com.wmusial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor // wszystkie konstruktory
@NoArgsConstructor // konstruktor bazowy pusty
@Entity
@Table(name="user")

public @Data class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
