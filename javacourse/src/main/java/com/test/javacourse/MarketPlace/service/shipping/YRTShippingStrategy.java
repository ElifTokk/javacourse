package com.test.javacourse.MarketPlace.service.shipping;

public class YRTShippingStrategy implements ShippingStrategy{

    @Override
    public double calculate(double weight) {
        return weight * 3;
    }
}
