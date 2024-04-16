package com.test.javacourse.MarketPlace.service.shipping;

public class ShippingCostCalculator {

    private ShippingStrategy shippingStrategy;

    public ShippingCostCalculator(ShippingStrategy strategy) {
        this.shippingStrategy = strategy;
    }

    public double calculateCost(double weight) {
        return shippingStrategy.calculate(weight);
    }
}
