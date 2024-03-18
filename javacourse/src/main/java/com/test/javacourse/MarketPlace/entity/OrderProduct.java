package com.test.javacourse.MarketPlace.entity;

import jakarta.persistence.*;

@Table
@Entity
public class OrderProduct extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private String orderProductDescription;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getOrderProductDescription() {
        return orderProductDescription;
    }

    public void setOrderProductDescription(String orderProductDescription) {
        this.orderProductDescription = orderProductDescription;
    }
}
