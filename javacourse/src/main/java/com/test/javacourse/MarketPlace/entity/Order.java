package com.test.javacourse.MarketPlace.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity implements Serializable {


    private static final long serialVersionUID = 1L;
    @Column
    private String orderNumber;
    private Date orderDate;
    private String orderDescription;
    private Double totalAmount;

    @ManyToOne
    private Users users;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderProduct> orderProducts = new HashSet<>();


}
