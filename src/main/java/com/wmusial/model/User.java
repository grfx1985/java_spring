package com.wmusial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    // role uzytkownika

    public enum Role { ADMIN , USER }

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER; // 0 - admin , 1 - user

}
