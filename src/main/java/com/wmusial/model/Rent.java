package com.wmusial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor // wszystkie konstruktory
@NoArgsConstructor // konstruktor bazowy pusty
@Entity
@Table(name="rent")

public @Data class Rent extends BaseEntity {
}
