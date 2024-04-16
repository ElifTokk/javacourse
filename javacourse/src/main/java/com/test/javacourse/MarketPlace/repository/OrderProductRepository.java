package com.test.javacourse.MarketPlace.repository;

import com.test.javacourse.MarketPlace.entity.Order;
import com.test.javacourse.MarketPlace.entity.OrderProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {

    List<OrderProduct> findAllByOrder(Order order);
}
