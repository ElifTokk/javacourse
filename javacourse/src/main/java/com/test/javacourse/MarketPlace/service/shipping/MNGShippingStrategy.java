package com.test.javacourse.MarketPlace.service.shipping;

public class MNGShippingStrategy implements ShippingStrategy{
    @Override
    public double calculate(double weight) {
        return weight * 2 + 5;
    }
}
