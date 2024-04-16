package com.test.javacourse.MarketPlace.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name = "product")
@Entity
@Getter
@Setter
public class Product extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;



    @Column
    private String name;

    @Column
    private String category;

    private String photoUrl;

    private String description;

    private Double price;

    private int weight;


    @OneToMany(mappedBy = "product", fetch =FetchType.EAGER)
    private Set<OrderProduct> orderProducts = new HashSet<>();


}
