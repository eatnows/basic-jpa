package me.eatnows.bookmanager.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    private Long id;
}
