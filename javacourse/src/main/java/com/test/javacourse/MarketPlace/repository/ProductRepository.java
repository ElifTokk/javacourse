package com.test.javacourse.MarketPlace.repository;

import com.test.javacourse.MarketPlace.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
