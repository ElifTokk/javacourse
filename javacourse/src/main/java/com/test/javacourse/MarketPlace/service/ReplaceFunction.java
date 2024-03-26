package com.test.javacourse.MarketPlace.service;


@FunctionalInterface
public interface ReplaceFunction {

    String replace(String template, String name, String orderNumber);
}
