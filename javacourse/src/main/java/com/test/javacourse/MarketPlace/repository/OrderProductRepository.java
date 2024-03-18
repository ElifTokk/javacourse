package com.test.javacourse.MarketPlace.repository;

import com.test.javacourse.MarketPlace.entity.OrderProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {


}
