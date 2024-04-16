package com.test.javacourse.MarketPlace.service.shipping;

public class SRTShippingStrategy implements ShippingStrategy{
    @Override
    public double calculate(double weight) {
        return weight * 2.1 + 2;
    }
}
