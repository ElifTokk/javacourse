package com.test.javacourse.MarketPlace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Users extends BaseEntity{

    private String name;
    private String lastName;
    private String phoneNumber;
    private boolean premium;

}
